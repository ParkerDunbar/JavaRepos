package dunbar.parker.csc180.httpconnect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Save {
	private Map<String, List<Integer>> search = new HashMap<>();
	private RandomAccessFile file;
	private int nextOffset = 8;

	public Save() throws IOException {
		boolean readOffset = new File("crawler.txt").exists();
		file = new RandomAccessFile("crawler.txt", "rw");
		if (readOffset) {
			nextOffset = file.read();
		}
	}

	public void getTheGoods(ArrayList<String> goods) throws IOException {
		while(goods.size() != 0) {
			ArrayList<String> oneLinkStuff = getOneLink(goods);
			countwords(oneLinkStuff);
			for(int i = 0; i < oneLinkStuff.size(); i++) {
				goods.remove(0);
			}
		}
	
	}

	private void countwords(ArrayList<String> words) throws IOException {
		ArrayList<String> alreadyCounted = new ArrayList<>();
		String stuff = "";
		for (int i = 0; i < words.size(); i++) {
			int tempCount = 0;
			int count = 0;
			String countThis = words.get(i);
			
			for (int o = 0; o < words.size(); o++) {
				if (countThis.equalsIgnoreCase(words.get(o))) {
					if(!alreadyCounted.contains(countThis.toLowerCase())) {
						count++;
					}
				}
				tempCount = count;
			}
			count = 0;
			if(!alreadyCounted.contains(countThis.toLowerCase())) {
				stuff += countThis + "\n" + tempCount + "\n";
				alreadyCounted.add(countThis.toLowerCase());
			}
		}
		combination(stuff);
	}

	private ArrayList<String> getOneLink(ArrayList<String> goods) {
		ArrayList<String> oneLinkStuff = new ArrayList<String>();
		boolean firstFound = false;
		for (int i = 0; i < goods.size(); i++) {
			if (Pattern.matches("[a-z|A-Z|\\/|:]+\\/((?:[a-z|A-Z|0-9]+\\.)*[a-z|A-Z|0-9]+\\.[a-z|A-Z]+\\/?).*",
					goods.get(i))) {
				if (Pattern.matches("[a-z|A-Z|\\/|:]+\\/((?:[a-z|A-Z|0-9]+\\.)*[a-z|A-Z|0-9]+\\.[a-z|A-Z]+\\/?).*",
						goods.get(i)) && firstFound) {
					break;
				}
				firstFound = true;
			}
			if (firstFound) {
				oneLinkStuff.add(goods.get(i));
			}
		}
		return oneLinkStuff;
	}

	private void combination(String stuff) throws IOException {
		String serialize = "";
		String word = "";
		String link = "";
		String count = "";
		String[] split = stuff.split("\n");
		for(int i = 1; i < split.length - 1; i+=2) {
			word = split[i+1];
			link = split[0];
			count = split[i];
			serialize += split[i] + split[0] + split[i+1];
			serializeThis(word, link, count);
		}
		
	}
	
	private void serializeThis(String word, String link, String count) throws IOException {
		String formatted = String.format("%255s%300s%3s", word, link, count);
		write(formatted, word);
	}
	
	private void write(String formatted, String word) throws IOException {
		addToSearchIndex(word, (nextOffset - 8) / 558);
		saveHashMap("crawler.ser", search);
		byte[] buffer;
		buffer = formatted.getBytes();
		
		file.seek(nextOffset);
		file.write(buffer);
		nextOffset += buffer.length;
		updateNextOffset();
	}
	
	private void addToSearchIndex(String word, int index) {
		List<Integer> list = search.get(word);
		if(list == null) {
			list = new ArrayList<>();
			search.put(word, list);
		}
		list.add(index);
		
	}
	
	private void saveHashMap(String filePath, Map<String, List<Integer>> hash) throws IOException {
		try(FileOutputStream out = new FileOutputStream(filePath)) {
			try(ObjectOutputStream obj = new ObjectOutputStream(out)) {
				obj.writeObject(hash);
			}
		}
	}

	private void updateNextOffset() throws IOException {
		int currentOffset = nextOffset;
		file.seek(0);
		file.writeInt(currentOffset);
	}
}
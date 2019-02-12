package dunbar.parker.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Database<T extends Storable> {
	private RandomAccessFile file;
	private T storage;
	private int nextOffset = 8;
	

	
	public Database(String path, T object) throws IOException {
		storage = object;
		boolean readOffsetFromFile = new File(path).exists();
		file = new RandomAccessFile(path, "rw");
		if(readOffsetFromFile) {
			nextOffset = file.readInt();
		}
		
	}
	
	public void insert(T obj) throws IOException {
		byte[] buffer = obj.serialize().getBytes();
		if(buffer.length != obj.serializedSize()) {
			throw new IllegalArgumentException("serialized size is not as promised");
		}
		file.seek(nextOffset);
		file.write(buffer);
		nextOffset += buffer.length;
		updateNextOffset();
	}
	
	public T lookup(int index) throws IOException {
		byte[] buffer = new byte[storage.serializedSize()];
		int byteSeek = 8 + (index * storage.serializedSize());
		file.seek(byteSeek);
		file.readFully(buffer);
		String deserialized = new String(buffer);
		storage = (T) storage.deserialize(deserialized);
		return storage;
		
	}
	
	
	public void remove(int index) throws IOException {
		byte[] buffer = new byte[storage.serializedSize()];
		
		for(int c = 8 + (index * storage.serializedSize());
				c < nextOffset - storage.serializedSize(); 
				c += storage.serializedSize()) {
			
			file.seek(c + storage.serializedSize());
			file.readFully(buffer);
			file.seek(c);
			file.write(buffer);
		}
		file.setLength(nextOffset - storage.serializedSize());
	}
	
	private void updateNextOffset() throws IOException {
		int currentOffset = nextOffset;
		file.seek(0);
		file.writeInt(currentOffset);
	}
	
}

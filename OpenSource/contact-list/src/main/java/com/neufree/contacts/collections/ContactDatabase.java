package com.neufree.contacts.collections;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neufree.contacts.Contact;

public class ContactDatabase {
	private RandomAccessFile file;
	
	private int nextOffset = 8;
	
	public ContactDatabase(String path) throws IOException {
		boolean readOffsetFromFile = new File(path).exists();
		file = new RandomAccessFile(path, "rw");
		if(readOffsetFromFile) {
			nextOffset = file.readInt();
		}
	}
	
	public void insert(Contact c) throws IOException {
		byte[] buffer;
		String byteArray = c.serialize();
		buffer = byteArray.getBytes();
		
		file.seek(nextOffset);
		file.write(buffer);
		nextOffset += buffer.length;
		updateNextOffset();
	}
	
	private void updateNextOffset() throws IOException {
		int currentOffset = nextOffset;
		file.seek(0);
		file.writeInt(currentOffset);
	}
	
	public Contact read(int index) throws IOException {
		byte[] buffer = new byte[1044];
		int byteSeek = 8 + (index * 1044);
		file.seek(byteSeek);
		file.readFully(buffer);
		
		Contact c = new Contact();
		c = c.deserialize(buffer);
		return c;
	}
	//String firstName = formatted.substring(0, 255).trim(); // 1044
}

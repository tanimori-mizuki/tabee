package com.example.service.memory;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.UploadPathConfiguration;
import com.example.domain.memory.Memory;
import com.example.domain.memory.MemoryImage;
import com.example.mapper.memory.MemoryMapper;

/**
 * 思い出情報取得するサービス.
 * 
 * @author masashi.nose
 *
 */
@Service
@Transactional
public class GetMemoryService {

	@Autowired
	private MemoryMapper memoryMapper;

	@Autowired
	private UploadPathConfiguration uploadPathConfiguration;
	

	/**
	 * 思い出全件取得.
	 * 
	 * @return 思い出リスト.
	 * @throws IOException
	 */
	public List<Memory> findAllMemories() throws IOException {
		List<Memory> memoryList = memoryMapper.selectAll();
		if (memoryList.size() == 0) {
			return Collections.emptyList();
		}

		for (Memory memory : memoryList) {
			List<MemoryImage> memoryImageList = memory.getMemoryImageList();
			if (memoryImageList.size() != 0) {
				int count = 0;
				for (MemoryImage memoryImage : memoryImageList) {
					String uploadPath = uploadPathConfiguration.getUploadPath() + "memory/"
							+ memoryImage.getImagePath();

					try (FileInputStream fis = new FileInputStream(uploadPath);) {
						StringBuffer data = new StringBuffer();
						ByteArrayOutputStream os = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						while (true) {
							int len = fis.read(buffer);
							if (len < 0) {
								break;
							}
							os.write(buffer, 0, len);
						}
						String base64 = new String(
								org.apache.tomcat.util.codec.binary.Base64.encodeBase64(os.toByteArray()), "ASCII");
						data.append("data:image/jpeg;base64,");
						data.append(base64);

						memoryImageList.get(count).setImagePath(data.toString());
						count++;

					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		}
		
		return memoryList;
	}

}

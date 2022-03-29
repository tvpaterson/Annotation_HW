package com.example.AnnotationHomework;

import com.example.AnnotationHomework.models.File;
import com.example.AnnotationHomework.models.Folder;
import com.example.AnnotationHomework.models.User;
import com.example.AnnotationHomework.repositories.FileRepository;
import com.example.AnnotationHomework.repositories.FolderRepository;
import com.example.AnnotationHomework.repositories.UserRepository;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnnotationHomeworkApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createFile(){
		User user = new User("John");
		userRepository.save(user);

		Folder folder = new Folder("Naughty Folder", user);
		folderRepository.save(folder);

		File file = new File("Dont_open_this_mum", ".txt", 60, folder);
		fileRepository.save(file);

	}

}

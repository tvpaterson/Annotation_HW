package com.example.AnnotationHomework.components;

import com.example.AnnotationHomework.models.File;
import com.example.AnnotationHomework.models.Folder;
import com.example.AnnotationHomework.models.User;
import com.example.AnnotationHomework.repositories.FileRepository;
import com.example.AnnotationHomework.repositories.FolderRepository;
import com.example.AnnotationHomework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        User user1 = new User("Tam");
        userRepository.save(user1);

        User user2 = new User("Tay");
        userRepository.save(user2);

        Folder folder1 = new Folder("CodeClan", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Clockwise", user1);
        folderRepository.save(folder2);

        Folder folder3 = new Folder("CodeClan", user2);
        folderRepository.save(folder3);

        File file1 = new File("Shite_cover_letters", ".pdf", 10, folder1);
        fileRepository.save(file1);

        File file2 = new File("love_letter_to_my_mistress", ".wrd", 6, folder1);
        fileRepository.save(file2);

        File file3 = new File("Shite_cover_letters", ".pdf", 9, folder2);
        fileRepository.save(file3);

        File file4 = new File("love_letter_to_my_mistress", ".wrd", 2, folder2);
        fileRepository.save(file4);

    }
}

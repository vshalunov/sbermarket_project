package com.github.zlwqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PictureUploadComponent {
    private final SelenideElement uploadButton = $("#uploadPicture");

    public void uploadFile(String fileForUpload) {
        uploadButton.uploadFile(new File("src/test/resources/" + fileForUpload));
    }

}

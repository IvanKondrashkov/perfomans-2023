package ru.kondrashkov.composite

class Folder {
    String name
    List<Folder> folders = []

    Folder(String name) {
        this.name = name
    }

    void addFolder(Folder folder) {
        this.folders.add(folder)
    }

    void addFolder(List<Folder> folders) {
        this.folders.addAll(folders)
    }

    String getPath() {
        return folders.join('\\')
    }
}
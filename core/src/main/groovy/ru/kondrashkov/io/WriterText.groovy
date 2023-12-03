package ru.kondrashkov.io

class WriterText {
    static void saveText(File file) {
        file.withWriter { writer ->
            writer.write('Hello World!')
        }
    }

    static void saveTextWithResource(File file) {
        try(FileWriter writer = new FileWriter(file)) {
            writer.write('Hello World!')
        }
    }
}
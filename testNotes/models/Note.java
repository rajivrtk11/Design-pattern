package testNotes.models;

public class Note {
    private final String id;
    private final String title;
    private final String description;

    public static NotesBuider buider() {
        return new NotesBuider();
    }


    public static class NotesBuider {
        private String id;
        private String title;
        private String description;

        public NotesBuider setId(String id) {
            this.id = id;
            return this;
        }

        public NotesBuider setTitle(String title) {
            this.title = title;
            return this;
        }

        public NotesBuider setDescription(String description) {
            this.description = description;
            return this;
        }

        public Note build() {
            return new Note(this.id, this.title, this.description);
        }
    }

    public Note(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

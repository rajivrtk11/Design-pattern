The **Adapter Design Pattern** is a structural design pattern that allows objects with incompatible interfaces to work together. The adapter acts as a bridge between two incompatible interfaces by converting one interface into another, which the client expects. It enables reusability of existing functionality by adapting interfaces without modifying the existing code.

### Key Components:
1. **Target Interface**: This is the interface that the client expects to work with.
2. **Adaptee**: This is the existing class that has the functionality you want to use but doesn't match the expected interface.
3. **Adapter**: This class implements the target interface and translates calls from the target interface to the adaptee's methods.
4. **Client**: The class that interacts with the target interface.

### Real-World Example:
Imagine you have an app that works with different power outlets from various countries. You have a European plug (which expects a round socket), but you're in the US where sockets are flat. You would need a power **adapter** to bridge the difference between the plug and the socket.

### Example of the Adapter Pattern in Java

Let's say we are building an application that uses a new `AdvancedMediaPlayer` interface for playing media files but we also have an existing `MediaPlayer` interface in our system.

#### Step 1: Define the Target Interface (`MediaPlayer`)

```java
// Target interface expected by the client
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

#### Step 2: Define the Adaptee Interface (`AdvancedMediaPlayer`)

```java
// Existing interface that needs to be adapted
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
```

#### Step 3: Implement the Adaptee Classes

```java
// Concrete implementation of the Adaptee
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // Do nothing
    }
}

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // Do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
```

#### Step 4: Create the Adapter Class

The `MediaAdapter` implements the `MediaPlayer` interface and translates the requests to the `AdvancedMediaPlayer`.

```java
// Adapter class implementing the Target interface
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
```

#### Step 5: Implement the Client Class

The `AudioPlayer` acts as the client, using `MediaPlayer` but can play different formats through the adapter.

```java
// Client class using the adapter
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // Built-in support for mp3
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        // Use the adapter for other formats
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
```

#### Step 6: Client Usage Example

```java
public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("avi", "movie.avi");
    }
}
```

### Output:
```
Playing mp3 file. Name: song.mp3
Playing mp4 file. Name: video.mp4
Playing vlc file. Name: movie.vlc
Invalid media. avi format not supported
```

### Advantages of the Adapter Pattern:
1. **Reuse existing code**: It allows you to reuse an existing class with incompatible interfaces by adapting it without modifying the existing code.
2. **Decouples client and adaptee**: The adapter decouples the client code from the specific implementation details of the adaptee.
3. **Single Responsibility Principle**: The adapter focuses on the task of translation between interfaces, promoting cleaner, more maintainable code.

### Real-World Usage:
- **Java I/O classes**: The `InputStreamReader` and `OutputStreamWriter` classes are adapters that allow byte streams to be treated as character streams.
- **Database drivers**: Adapters are used in many database frameworks to adapt SQL queries to different database implementations.

### Key Points:
- **Adapter pattern** can be used in situations where a class has the functionality you need but its interface is incompatible with what the client expects.
- It acts as a bridge between two interfaces, helping integrate existing functionality into new systems without rewriting them.


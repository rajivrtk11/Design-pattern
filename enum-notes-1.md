### **How Java Converts an `enum` into a Class**
In Java, `enum` is a **special type of class** that extends `java.lang.Enum<T>`. Internally, the compiler transforms your `enum` into a **final class** with static instances.

Let’s **decompile** your `TicketStatus` enum and see how Java represents it.

---

## **1️⃣ Your Original `enum`**
```java
enum TicketStatus {
    BOOKED("Your ticket is booked."),
    AVAILABLE("Seat is available."),
    CANCELLED("Booking is cancelled.");

    private final String message;

    TicketStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
```
---

## **2️⃣ How the Compiler Converts It**
If you decompile the `.class` file, it would look like this:

```java
public final class TicketStatus extends Enum<TicketStatus> {
    public static final TicketStatus BOOKED = new TicketStatus("BOOKED", 0, "Your ticket is booked.");
    public static final TicketStatus AVAILABLE = new TicketStatus("AVAILABLE", 1, "Seat is available.");
    public static final TicketStatus CANCELLED = new TicketStatus("CANCELLED", 2, "Booking is cancelled.");

    private final String message;

    // Private Constructor
    private TicketStatus(String name, int ordinal, String message) {
        super(name, ordinal);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    // Returns all enum values
    public static TicketStatus[] values() {
        return new TicketStatus[] { BOOKED, AVAILABLE, CANCELLED };
    }

    // Returns enum instance by name
    public static TicketStatus valueOf(String name) {
        return Enum.valueOf(TicketStatus.class, name);
    }
}
```

---

## **3️⃣ Explanation of the Generated Code**
🔹 **`extends Enum<TicketStatus>`** → Every enum **implicitly** extends `java.lang.Enum`.  
🔹 **Static Instances (`public static final`)** → Each enum constant (`BOOKED`, `AVAILABLE`, `CANCELLED`) is a **singleton instance** of `TicketStatus`.  
🔹 **Private Constructor (`private TicketStatus(...)`)** → Enums have a **private** constructor to **prevent new instances** from being created.  
🔹 **`values()` Method** → Returns an **array of all enum constants**.  
🔹 **`valueOf(String name)` Method** → Retrieves an enum constant by its **name**.

---

## **4️⃣ Why Is the Constructor Private?**
```java
private TicketStatus(String name, int ordinal, String message) {
    super(name, ordinal);
    this.message = message;
}
```
🔹 The constructor is **private** because enums **should not be instantiated manually**.  
🔹 The compiler **automatically** creates the enum instances as `public static final` fields.  
🔹 `super(name, ordinal)` calls the `Enum` constructor, setting the **name** (`BOOKED`) and **ordinal** (`0`, `1`, `2`, ...).

---

## **5️⃣ How It Works Internally**
When you do:
```java
TicketStatus status = TicketStatus.BOOKED;
System.out.println(status.getMessage()); // Output: Your ticket is booked.
```
🔹 `TicketStatus.BOOKED` refers to the **singleton** instance created in `public static final TicketStatus BOOKED`.  
🔹 It calls the `getMessage()` method, which returns `"Your ticket is booked."`.

---

## **6️⃣ Summary**
✅ **Enums in Java are actually final classes that extend `Enum<T>`**.  
✅ **Each enum constant is a `public static final` singleton instance**.  
✅ **The constructor is private**, preventing external instantiation.  
✅ **Methods like `values()` and `valueOf()` are auto-generated** by the compiler.

Would you like a real-world example using **JPA Enum Mapping in Spring Boot?** 🚀
### **Enums in Java**
In Java, an `enum` is a special data type used to define **a set of named constant values**. Enums are type-safe and can be used to represent a fixed set of values like **days of the week, order statuses, ticket categories, etc.**

---

### ✅ **Basic Enum Example**
```java
enum TicketStatus {
    BOOKED,
    AVAILABLE,
    CANCELLED
}
```
**Usage:**
```java
TicketStatus status = TicketStatus.BOOKED;
System.out.println(status); // Output: BOOKED
```

---

### ✅ **Enum with Values (Custom Fields)**
Enums can have **fields, constructors, and methods**.

```java
enum TicketStatus {
    BOOKED(1), AVAILABLE(2), CANCELLED(3);

    private final int code;

    TicketStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
```
**Usage:**
```java
System.out.println(TicketStatus.BOOKED.getCode()); // Output: 1
```

---

### ✅ **Enum with Multiple Fields (Code & Description)**
```java
enum TicketStatus {
    BOOKED(1, "Seat is booked"),
    AVAILABLE(2, "Seat is available"),
    CANCELLED(3, "Booking is cancelled");

    private final int code;
    private final String description;

    TicketStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() { return code; }
    public String getDescription() { return description; }
}
```
**Usage:**
```java
TicketStatus status = TicketStatus.BOOKED;
System.out.println(status.getCode());        // Output: 1
System.out.println(status.getDescription()); // Output: Seat is booked
```

---

### ✅ **Enum Methods (Find Enum by Value)**
To get an enum constant by **code**:
```java
public static TicketStatus fromCode(int code) {
    for (TicketStatus status : TicketStatus.values()) {
        if (status.getCode() == code) {
            return status;
        }
    }
    throw new IllegalArgumentException("Invalid code: " + code);
}
```
**Usage:**
```java
TicketStatus status = TicketStatus.fromCode(2);
System.out.println(status); // Output: AVAILABLE
```

---

### ✅ **Enum Implementing an Interface**
Enums can implement interfaces to add **common behaviors**.
```java
interface Status {
    String getMessage();
}

enum TicketStatus implements Status {
    BOOKED {
        public String getMessage() { return "Your ticket is booked."; }
    },
    AVAILABLE {
        public String getMessage() { return "Seat is available."; }
    },
    CANCELLED {
        public String getMessage() { return "Booking is cancelled."; }
    }
}
```
**Usage:**
```java
System.out.println(TicketStatus.BOOKED.getMessage()); // Output: Your ticket is booked.
```

---

### ✅ **Key Takeaways**
✅ **Enums** provide a clean way to represent fixed values.  
✅ You can **add fields and methods** inside enums.  
✅ Use `values()` to iterate through enums.  
✅ Use `fromCode(int code)` to retrieve an enum dynamically.  
✅ Enums can **implement interfaces** for added functionality.

Would you like an **example with a database (JPA enum mapping)**? 🚀
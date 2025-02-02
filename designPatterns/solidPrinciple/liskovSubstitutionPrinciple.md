Sure! Let's go step by step to **correctly implement the Rectangle-Square relationship while following the Liskov Substitution Principle (LSP).**

---

### ❌ **Violation of LSP**
Here’s the common incorrect implementation where `Square` extends `Rectangle`, causing LSP violations.

```java
class Rectangle {
    protected int width, height;

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    public int getArea() { return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = this.height = width;  // 🚨 Violates LSP
    }

    @Override
    public void setHeight(int height) {
        this.width = this.height = height;  // 🚨 Violates LSP
    }
}
```
### 🔴 **Why is this a violation?**
1. The `Square` class **overrides** `setWidth()` and `setHeight()` in a way that breaks expectations.
2. If a method is written expecting a `Rectangle`, substituting it with `Square` leads to unexpected behavior.

#### Example of unexpected behavior:
```java
public static void printArea(Rectangle rect) {
    rect.setWidth(4);
    rect.setHeight(5);
    System.out.println("Expected Area: " + (4 * 5));
    System.out.println("Actual Area: " + rect.getArea()); // ❌ Wrong output for Square
}
```
✅ Expected Output (if it's a `Rectangle`):
```
Expected Area: 20  
Actual Area: 20  
```
❌ But if we pass a `Square` object:
```
Expected Area: 20  
Actual Area: 25  // Wrong! Because width & height are forced to be the same
```
This violates **LSP** because the `Square` class **changes** the original contract of `Rectangle`.

---

### ✅ **Correct Implementation Following LSP**
The correct approach is to **avoid inheritance** and instead use a common abstraction, like an interface or an abstract class.

```java
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    protected int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public int getArea() { return width * height; }
}

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public void setSide(int side) { this.side = side; }

    @Override
    public int getArea() { return side * side; }
}
```

Now, both `Rectangle` and `Square` follow the **same contract** but don’t interfere with each other’s logic.

---

### ✅ **Now it works as expected!**
```java
public static void printArea(Shape shape) {
    System.out.println("Area: " + shape.getArea());
}

public static void main(String[] args) {
    Shape rect = new Rectangle(4, 5);
    Shape square = new Square(4);

    printArea(rect);   // Output: Area: 20
    printArea(square); // Output: Area: 16
}
```
---

### 🔹 **Key Takeaways**
✅ **Avoid using inheritance when behavior is fundamentally different.**  
✅ **Use abstractions (`interface Shape`) to separate concerns.**  
✅ **Substituting a `Rectangle` with a `Square` should not change expected behavior.**

Would you like an example with a **real-world use case** (like UI elements)? 🚀
The **Liskov Substitution Principle (LSP)** states that a subclass should be replaceable for its superclass without altering the correctness of the program. Violating this principle usually happens when a subclass changes the expected behavior of its parent class.

### **Rectangle and Square Example (LSP Violation)**
A common example of LSP violation is using **a `Square` class that extends `Rectangle`**.

#### **Incorrect Implementation (LSP Violation)**
```java
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.width = width;
        super.height = width; // Force height to be equal
    }

    @Override
    public void setHeight(int height) {
        super.height = height;
        super.width = height; // Force width to be equal
    }
}
```
#### **Why is this a Violation?**
- A `Rectangle` assumes **width and height are independent**, but a `Square` enforces **width == height**.
- If a function relies on `Rectangle`'s behavior, substituting `Square` **breaks** expectations.

#### **Example of Broken Behavior**
```java
public static void testLiskov(Rectangle rect) {
    rect.setWidth(10);
    rect.setHeight(5);
    System.out.println("Expected area: " + (10 * 5) + ", Actual area: " + rect.getArea());
}

public static void main(String[] args) {
    Rectangle rect = new Rectangle();
    testLiskov(rect); // Expected output: 50

    Rectangle square = new Square();
    testLiskov(square); // Unexpected output: 25 (since width and height are forced equal)
}
```
💥 **Problem:** The function expects `Rectangle` behavior but gets unexpected results with `Square`.

---

### **Correct Approach (Without Violating LSP)**
Instead of making `Square` inherit from `Rectangle`, we should **use composition or separate them**.

#### **Fix using Composition**
```java
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}
```
Now, `Rectangle` and `Square` **don't share a broken inheritance relationship**, and both **correctly implement** `Shape`.

✅ **Now we can substitute `Shape` without breaking behavior!**
```java
public static void testLiskov(Shape shape) {
    System.out.println("Area: " + shape.getArea());
}

public static void main(String[] args) {
    testLiskov(new Rectangle(10, 5)); // 50
    testLiskov(new Square(5));        // 25
}
```

---

### **Key Takeaways**
✅ Avoid forcing a subclass (`Square`) to modify the expected behavior of its superclass (`Rectangle`).  
✅ Instead of inheritance, **prefer composition** when behavior differs.  
✅ The **Liskov Substitution Principle** ensures that objects of a superclass can be replaced with objects of a subclass **without altering correctness**.
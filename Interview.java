public class Interview {
    public static void main(String[] args) {
        /*
          Implement the CustomStack class:

          CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
          void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
          int pop() Pops and returns the top of stack or -1 if the stack is empty.
          void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.

           Your CustomStack object will be instantiated and called as such:
            CustomStack obj = new CustomStack(maxSize);
            obj.push(x);
            int param_2 = obj.pop();
            obj.increment(k,val);
        update i -> i-(k-1)
        4
        k = 2, val = 4
        idx 4 - (4)
        1,2,3,4
          Please add a main method which evaluates and displays one or more test cases.
        */

        /*
        You work for an e-commerce company. You have two tables:
        Orders: order_id (INT, PRIMARY KEY), customer_id (INT), order_date (DATE), total_amount (DECIMAL)
        OrderItems: order_item_id (INT, PRIMARY KEY), order_id (INT, FOREIGN KEY referencing Orders), product_id (INT), quantity (INT), price (DECIMAL)
        Task:
        Write a SQL query to find the following for each customer in the year 2023:

        The total amount spent by the customer.

        The customer's rank in terms of total spending within their city (assume a Customers table exists with customer_id and city).
        Handle ties in spending (e.g., if two customers have the same total spending, they should have the same rank).

        The customer's highest single order amount.

        The date of the customer's first order.

        Assumptions:
        You have a Customers table with customer_id and city.
        The database system supports window functions (e.g., RANK, DENSE_RANK, ROW_NUMBER, FIRST_VALUE, etc.).
        We'll use standard SQL, but slight syntax adjustments might be needed for specific databases.
        */

        /*

        you are given a list of time intervals,
        where each interval is represented as a pair of integers [start, end].
        Write a function that merges all overlapping intervals and returns a new list of non-overlapping intervals.

        Example:
        Input: [[1,3],[8,10],[15,18], [1,5], [2,6]]
        [[1,3],[1,5],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]

        Input: [[1,4],[4,5]]
        Output: [[1,5]]

        Input: [[1,3],[2,6],[8,10],[15,18],[1,9]]
        Output: [[1, 10], [15, 18]]

        Input: []
        Output: []

        M-1
        i - 0 to n
         j -> i+1 to n
        o(n*n)

        M-2


        */


    }
}

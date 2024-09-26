queue = []

def enqueue():
    element = input("Enter the element: ")
    queue.append(element)
    print("Element added to queue")

def dequeue():
    if not queue:
        print("Queue is empty")
    else:
        e = queue.pop(0)  # Change 10 to 0 to dequeue the first element
        print("Removed element:", e)

def display():
    if not queue:
        print("Queue is empty")
    else:
        print("Queue:", queue)

def menu():
    while True:
        print("\nSelect the operation: 1. Add 2. Remove 3. Show 4. Quit")
        choice = int(input())
        
        if choice == 1:
            enqueue()
        elif choice == 2:
            dequeue()
        elif choice == 3:
            display()
        elif choice == 4:
            break
        else:
            print("Enter a valid choice")

# Start the program
menu()

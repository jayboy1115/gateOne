phone_book = []
def print_display_menu():
    print("1. Add Contact")
    print("2. Remove Contact")
    print("3. Find Contact by Phone Number")
    print("4. Find Contact by First Name")
    print("5. Find Contact by Last Name")
    print("6. Edit Contact")
    print("7. Exit")

def add_contact():
    first_name = input("Enter first name: ")
    last_name = input("Enter last name: ")
    phone_number = input("Enter phone number: ")
    phone_book.append(f"{first_name} {last_name} {phone_number}")
    print("Contact added successfully!")

def remove_contact():
    first_name = input("Enter first name: ")
    last_name = input("Enter last name: ")
    for contact in phone_book:
        if first_name + " " + last_name in contact:
            phone_book.remove(contact)
            print("Contact removed successfully!")
            return 
    print("Contact not found!")

def find_contact_by_phone_number():
    phone_number = input("Enter phone number: ")
    for contact in phone_book:
        if phone_number in contact:
            print(contact)
            return
    print("Contact not found!")

def find_contact_by_first_name():
    first_name = input("Enter first name: ")
    for contact in phone_book:
        if contact.startswith(first_name):
            print(contact)
            return
    print("Contact not found!")

def find_contact_by_last_name():
    last_name = input("Enter last name: ")
    for contact in phone_book:
        if " " + last_name in contact:
            print(contact)
            return
    print("Contact not found!")

def edit_contact():
    first_name = input("Enter first name: ")
    last_name = input("Enter last name: ")
    for contact in phone_book:
        if first_name + " " + last_name in contact:
            new_first_name = input("Enter new first name: ")
            new_last_name = input("Enter new last name: ")
            new_phone_number = input("Enter new phone number: ")
            phone_book.remove(contact)
            phone_book.append(f"{new_first_name} {new_last_name} {new_phone_number}")
            print("Contact updated successfully!")
            return
    print("Contact not found!")

while True:
    print_display_menu()
    print("WELCOME TO JOHNSON PHONEBOOK RECORD")
    print("Choose an option")
    option = int(input())
    if option == 1:
        add_contact()
    elif option == 2:
        remove_contact()
    elif option == 3:
        find_contact_by_phone_number()
    elif option == 4:
        find_contact_by_first_name()
    elif option == 5:
        find_contact_by_last_name()
    elif option == 6:
        edit_contact()
    elif option == 7:
        break
    else:
        print("Invalid choice!")


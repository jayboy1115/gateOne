def get_card_type(card_number):
    if card_number.startswith("4"):
        return "Visa"
    elif card_number.startswith("5"):
        return "Mastercard"
    elif card_number.startswith("37"):
        return "American Express"
    elif card_number.startswith("6"):
        return "Discover"
    else:
        return "Invalid card"

def get_validity_status(card_number):
    sum = 0
    alternate = False
    for count in range(len(card_number) - 1, -1, -1):
        num = int(card_number[count])
        if alternate:
            num *= 2
            if num > 9:
                num -= 9
        sum += num
        alternate = not alternate
    return "valid" if sum % 10 == 0 else "invalid"

def main():
    card_number = input("Hello, kindly enter card details to verify:\n")
    card_type = get_card_type(card_number)
    digit_length = len(card_number)
    validity_status = get_validity_status(card_number)
    print("******************************************")
    print("**credit card type:", card_type)
    print("**credit card number:", card_number)
    print("**credit card digit length:", digit_length)
    print("**credit card validity status:", validity_status)
    print("******************************************")

if __name__ == "__main__":
    main()

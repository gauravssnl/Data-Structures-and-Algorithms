class Shirt:
    PRICE = 500
    def __init__(self, quantity):
        self._total_cost = quantity * Shirt.PRICE
        print("Total cost:", self._total_cost)

if __name__ == "__main__":
    shirt = Shirt(5);
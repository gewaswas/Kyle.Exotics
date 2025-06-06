# Kyle Bryan David ITCC121 Project
def reptile_morph_calculator(): #Defining Main Functions 
    
    print("Kyle.Exotic Reptile Morph Calculator")
    print("This Tool can help the Reptile World to calculate the potential offspring from parents reptile.\n")
    
    
    species = ""
    morph_prices = {}  
    possible_morphs = []  
    
    
    species = input("Enter the reptile species (e.g., Ball Python, Leopard Gecko, Reticulated Python): ")
    
    
    if "ball python" in species.lower():
        possible_morphs = ["Normal", "Albino", "Piebald", "Pastel", "Spider", "Clown", "Banana"]
        base_price = 1000.0  
    elif "Leopard gecko" in species.lower():
        possible_morphs = ["Normal", "Tangerine", "Hypo", "Super Hypo", "Albino", "Blizzard"]
        base_price = 2000.0
    elif "reticulated python" in species.lower():
        possible_morphs = ["Albino","Tiger","Golden Child","Motley"]
        base_price = 20000.0
    else:
        possible_morphs = ["Normal", "Albino", "Patternless", "Wild Type"]
        base_price = 1500.0
    
    
    print(f"\nAvailable morphs for {species}:")
    for i, morph in enumerate(possible_morphs, 1):
        print(f"{i}. {morph}")
        
        morph_prices[morph] = base_price * (1 + (i * 0.5))  
    
    
    parent1 = ""
    parent2 = ""
    
    while parent1 not in possible_morphs:
        parent1 = input("\nEnter morph for Parent 1: ")
        if parent1 not in possible_morphs:
            print("Invalid morph. Please choose from the list above.")
    
    while parent2 not in possible_morphs:
        parent2 = input("Enter morph for Parent 2: ")
        if parent2 not in possible_morphs:
            print("Invalid morph. Please choose from the list above.")
    
   
    print("\nCalculating possible offspring morphs...Please wait Hehe!")
    
    
    
    offspring_morphs = set()  
    
    
    if parent1 == parent2:
        offspring_morphs.add(parent1)
        if parent1 != "Normal":
            offspring_morphs.add("Normal")  
    else:
        offspring_morphs.add(parent1)
        offspring_morphs.add(parent2)
        offspring_morphs.add("Normal")  
    
     # Special combo mag breed si kyle
    if ("Albino" in [parent1, parent2]) and ("Piebald" in [parent1, parent2]) and "Ball Python" in species:
        offspring_morphs.add("Albino Piebald")  
    
    # Display results
    print("\nPossible Offspring Morphs ")
    for morph in sorted(offspring_morphs):
        price = morph_prices.get(morph, base_price)
        print(f"- {morph} (Estimated value: ₱{price:.2f})")
    
   # Calculate average value
    if offspring_morphs:
        avg_value = sum(morph_prices.get(m, base_price) for m in offspring_morphs) / len(offspring_morphs)
        print(f"\nAverage offspring value: ₱{avg_value:.2f}")
    
        
    
    print("\nThank you for using Kyle.Exotic Reptile Morph Calculator!")

# Run the program
if __name__ == "__main__":
    reptile_morph_calculator()
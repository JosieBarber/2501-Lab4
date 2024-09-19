// Josie Barber and El Anderson

Notable Import Statements:
  - Optimal idea 1:
    - our algorithm sorts optimally when the highest numbers fill the bins completely
    - Ex: 10 7 10 10 10 2 2 2 2
      - [10]
      - [10]
      - [10]
      - unused: [2,2,2,2], no leftover space
  - Optimal idea 2:
    - our alg performs optimally when the largest and smallest numbers match to fill the bins completely
    - Ex: 10 , 6 , 8 8 8 2 2 2
      - [8 , 2]
      - [8 , 2]
      - [8 , 2]
      - unused [none], no leftover space
  - Not-optimal idea: 
    - our algorithms favors placing the biggest number first and can miss perfect fits if they are made of numbers smaller than the first three largest
    - Bin Size 20 , 9 , 17 17 17 10 10 10 10 10 10 
      - [17]
      - [17]
      - [17]
      - unused [10 , 10 , 10 , 10 , 10, 10], 9 spots leftover
      - out alg will take the 17 and put them in the bins and not have enough space for the 10s which would fit perfectly
  - Extra credit for not-optimal input
    - in this example our algorithm has 9/30 spots leftover, vs the ideal which has 0 spots
    - Our algorithm leaves 30% of the space unused vs 0% which is for a difference of 30%
    - this was calculated using: (totalUnusedSpace / (binCapacity*3)) - 0%

- Efficiency Analysis
  prep:
  scanner // Theta(1)
  place items in array // Theta(n)
  sort alg(insertion) // O(n^2)

  inside frontLoader:
  create arrays // Theta(1)
  for loop // runs n times
    for loop // runs 3 times for a total of 3n
    if statement // Theta(1*n)
  for loop // Theta(n)
  return statement // Theta(1)

  print statements // O(n) , mainly for unused items for loop

  This comes together to make T(n) = Theta(1) + Theta(n) + O(n^2) + Theta(1) + Theta(3n) + Theta(1n) + Theta(n) + Theta(1) + O(n)
  The big players in this are O(n^2), O(n) and Theta(n), O(n^2) is a dominating runtime compared to linear time
  This comes together to make T(n) in O(n^2) which is a polynomial runtime!
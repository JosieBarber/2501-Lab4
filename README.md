TODO:
- finish bin sort:
  - take cases when not just exactly bin size
  - manage unused imports (check)
- Show at least two examples for which your algorithm returns an optimal solution and at least one for which it doesn't (i.e. there exists a solution with more less total leftover volume than the one that your algorithm finds). 
  - Optimal idea 1:
    - 10 , 7, 10 10 10 2 2 2 2
    - alg searches for perfect fits first
  - Optimal 2:
    - 10 , 6 , 8 8 8 2 2 2
  - Optimal 3(extra): 
    - 3 , 9 , 1 1 1 1 1 1 1 1 1 
  - Un-optimal: 
    - Bin Size 20 , 9 , 17 17 17 10 10 10 10 10 10 
      - out alg will take the 17 and put them in the bins and not have enough space for the 10s which would fir perfectly
-  As an extra credit, compute the maximal difference between your solution and the optimal one (in percentage of the total space), show and justify your computations. (ASK PETER)
- Perform efficiency analysis
- documentation

Future us issues !!!!! :
    What if an element is larger than binSize????
    Handle printing bins when input includes 0
fileName = input('Enter file name: ')

# https://www.w3schools.com/python/python_try_except.asp
# https://stackoverflow.com/questions/5627425/what-is-a-good-way-to-handle-exceptions-when-trying-to-read-a-file-in-python

try:
  with open(fileName, 'r') as f:
    left = []
    right = []

    for line in f:
      values = line.split()
      left.append(int(values[0]))
      right.append(int(values[1]))

    left.sort()
    right.sort()

    total_distance = 0
    for i in range(len(left)):
      total_distance += abs(left[i] - right[i])
    
    print(f'Total distance: {total_distance}')
except FileNotFoundError:
  print(f'{fileName} not found!')
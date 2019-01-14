class IterationTraversal:
    def inputValidation(self, values):
        if (values == None) or (len(values) <= 0):
            print("Not a valid array")
            return True

    def findMax(self, values):
        self.values = values
        if not (self.inputValidation(values)):
            maxInArray = values[0]
            # language specific iteration
            for value in values:
                if value > maxInArray:
                    maxInArray = value
            print(maxInArray)
            # using the counter with range of length
            for i in range(len(values)):
                if values[i] > maxInArray:
                    maxInArray = values[i]
            print("maxInArray:", maxInArray)
            # using enumerate
            for i, value in enumerate(values):
                if value > maxInArray:
                    maxInArray = value
            print("Maximum:", maxInArray)
            return

    def findMin(self, values):
        if not (self.inputValidation(values)):
            minInArray = values[0]
            for value in values:
                if value < minInArray:
                    minInArray = value
            print("Minimum:", minInArray)
            return

    def findRange(self, values):
        # error handling , input validation
        if not (self.inputValidation(values)):
            minInArray = values[0]
            for value in values:
                if value < minInArray:
                    minInArray = value
            maxInArray = values[0]
            for value in values:
                if value > maxInArray:
                    maxInArray = value
            arrayRange = maxInArray - minInArray
            print("Array Range: ", arrayRange)
            return

    def findSum(self, values):
        if not (self.inputValidation(values)):
            sum = 0
            for value in values:
                sum += value
            print("Sum of Array values:", sum)
            return

    def printArray(self, values):
        if not (self.inputValidation(values)):
            print("Array:")
            for i in range(len(values)):
                print(values[i])


values = [1, 2, 3, 0, 8, 6, 7]
# values =[]
itr = IterationTraversal()
itr.findMax(values)
itr.findMin(values)
itr.findRange(values)
itr.findSum(values)
itr.printArray(values)

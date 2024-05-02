class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        freqDict = {}
        max =0
        for i in range(lowLimit, highLimit+1):
            sumVal = 0
            while i > 0:
                rem = i%10
                sumVal += rem
                i //= 10
            
            freqDict[sumVal] = freqDict.get(sumVal, 0)+1
            if max<freqDict[sumVal] :
                max = freqDict[sumVal]
        
        return max
        #most_common = Counter(freqDict.values()).most_common(1)[0][1]
        #return most_common
        





        
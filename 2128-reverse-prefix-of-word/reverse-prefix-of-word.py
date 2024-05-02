class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        val=0
        for k,i in enumerate(word):
            if i==ch:
                val=k
                break
        
        return word[val::-1]+word[val+1:]

        
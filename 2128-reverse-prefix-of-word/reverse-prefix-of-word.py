class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        for k in range(len(word)):
            if word[k]==ch:
                return word[k::-1]+word[k+1:]
        return word        
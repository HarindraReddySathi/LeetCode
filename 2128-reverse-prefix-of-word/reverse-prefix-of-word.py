# class Solution:
#     def reversePrefix(self, word: str, ch: str) -> str:
#         # val=0
#         for k in range(len(word)):
#             if word[k]==ch:
#                 # val=k
#                 return word[k::-1]+word[k+1:]
#         return word
class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        x=0
        for i in range(len(word)):
            if word[x]==ch:
                return word[x::-1]+word[x+1:]
            x+=1
        return word

              
        

        
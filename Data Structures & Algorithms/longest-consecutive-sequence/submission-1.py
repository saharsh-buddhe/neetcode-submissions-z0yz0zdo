class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        sets = set(nums)
        sets2 = list(sets)
        largest = 0
        curr = 0
        for val in sets:
            curr = 0
            if val - 1 not in sets:
                while val + curr in sets:
                    curr += 1
            largest = max(largest, curr)



        return largest
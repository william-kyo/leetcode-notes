# LeetCode Notes

算法是不可能在短时间就能突破的，只有持续不断的练习、思考。一开始我是畏惧刷题的，觉得刷题是“做题家”的行为，不够cool，这个错误的观点让我一直无法提高算法的功底。我工作的前三年就学完了常见的数据结构和算法，水平也仅仅是能够说出算法和数据结构的名字、使用场景。后来我发现“鄙视刷题”只是我的Imposter Syndrome，算法并不是要求我要去发明新的理论，而是需要去理解、练习。刷题就是一种高效率的学习方式。



| 序号 | 编号 | 题目名称                                   | 思路                                                         | 类型           | 难度 | 时间消耗 | 地址                                                         |
| ---- | ---- | ------------------------------------------ | ------------------------------------------------------------ | -------------- | ---- | -------- | ------------------------------------------------------------ |
| 1    | 109  | Convert  Sorted List to Binary Search Tree |                                                              | BST            | M    | 1h       | [link](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/) |
| 2    | 653  | Two  Sum IV - Input is a BST               | BFS，遍历每个节点，hash保存查找目标值 | BST            | E    | 1h       | [link](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/) |
| 3    | 530  | Minimum Absolute Difference in BST         |                                                              | BST            | E    | 25m      | [link](https://leetcode.com/problems/minimum-absolute-difference-in-bst/) |
| 4    | 501  | Find Mode in Binary Search Tree            | 全局记录特殊值(最大的统计数字)；inorder遍历树，不断把当前统计到的最大元素更新 | BST            | E    | 1h       | [link](https://leetcode.com/problems/find-mode-in-binary-search-tree/) |
| 5    | 208  | Implement Trie  (Prefix Tree)              | 关键在于单个节点如何定义                                     | Trie           | M    | 30m      | [link](https://leetcode.com/problems/implement-trie-prefix-tree/) |
| 6    | 677  | Map  Sum Pairs                             |                                                              | Trie           | M    | 30m      | [link](https://leetcode.com/problems/map-sum-pairs/)         |
| 7    | 594  | Longest  Harmonious Subsequence            |                                                              | Hash           | E    | 25m      | [link](https://leetcode.com/problems/longest-harmonious-subsequence/) |
| 8    | 128  | Longest  Consecutive Sequence              | 常规做法，需要先排序，排序的复杂度O(N*logN)                  | Hash           | H    | null     | [link](https://leetcode.com/problems/longest-consecutive-sequence/) |
| 9    | 242  | Valid  Anagram                             |                                                              | String         | E    | 15m      | [link](https://leetcode.com/problems/valid-anagram/)         |
| 10   | 409  | Longest  Palindrome                        | 直接累加偶数个数的字符的结果，奇数个数的字符去掉一个变偶数统计，最后根据是否含有奇数决定是否对结果+1；aaaccAbbb  最长回文 bcaAacb（7） | String         | E    | 25m      | [link](https://leetcode.com/problems/longest-palindrome/)    |
| 11   | 205  | Isomorphic  Strings                        |                                                              | String         | E    | null     | [link](https://leetcode.com/problems/isomorphic-strings/)    |
| 12   | 647  | Palindromic  Substring                     | 1.brutal  force, time complexity O(N^3); 2.用中位向外扩展统计，可以区分为偶数和奇数分别统计，确保不会重复 | String         | M    | 40m      | [link](https://leetcode.com/problems/palindromic-substrings/) |
| 13   | 9    | Palindrome  number                         |                                                              | String         | E    | 25m      | [link](https://leetcode.com/problems/palindrome-number/)     |
| 14   | 696  | Count  Binary Substrings                   | 利用中位向外扩展统计，前后指针向两边移动，确保两指针指向的字符不想等，并且同一个方向的字符要相等 | String         | E    | 25m      | [link](https://leetcode.com/problems/count-binary-substrings/) |
| 15   | 283  | Move  Zeroes                               | 简单的题目要控制在15m以内完成，开始浪费太多时间在尝试用快排解决，其实这道题用brutal  force就效率很高了 | Array & Matrix | E    | 25m      | [link](https://leetcode.com/problems/move-zeroes/)           |
| 16   | 566  | Reshape  the Matrix                        | brutal  force分析二维数组的i，j的相对关系                    | Array & Matrix | E    | 30m      | [link](https://leetcode.com/problems/reshape-the-matrix/)    |
| 17   | 141  | Linked  List Cycle                         | 快慢指针可以重叠，边界控制                                   | Linked List    | E    | 15m      | [link](https://leetcode.com/problems/linked-list-cycle/)     |
| 18   | 2    | Add  Two Numbers                           |                                                              | Linked List    | M    | 50m      | [link](https://leetcode.com/problems/add-two-numbers/)       |
| 19   | 485  | Max  Consecutive Ones                      | 太简单了，就当练习语言编程                                   | Array & Matrix | E    | 10m      |                                                              |
| 20   | 245  | Search  a 2D Matrix II                     | 从右顶点开始判断，如果当前数大于目标数则向左查找，如果当前数小于目标数则向下查找。在一个循环内就可以判断是否含有制定参数 | Array & Matrix | M    | null     | [link](https://leetcode.com/problems/search-a-2d-matrix-ii/) |
| 21   | 378  | Kth Smallest Element in a Sorted Matrix    | 方式一： 使用优先队列保存所有的元素，顺序从大到小； 方式二： 使用二分查找，左上角为最小，右下角为最大，使用范围查找确定中间值；统计范围中比中间值小的个数，对比是否大于目标k来判断左右选取范围。Time Complexity: O(log(n)) | Array & Matrix | M    | 28m       | [link](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/) |
| 22 | 645 | Set Mismatch | 方式一： Brutal Force，使用hash表统计每个数字的个数，个数为2的是出现异常的数字，遍历 1->n ，如果map不存在的就是缺失的数字。Time Complexity: O(n), Space Complexity: O(n) | Array & Matrix | E | 30m | [link](https://leetcode.com/problems/set-mismatch/) |


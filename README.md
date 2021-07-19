# LeetCode Notes

算法是不可能在短时间就能突破的，只有持续不断的练习、思考。一开始我是不想刷题的，觉得刷题是“做题家”的行为，不够cool，这个错误的观点让我一直无法提高算法的功底。我工作的前三年就学完了常见的数据结构和算法，水平也仅仅是能够说出算法和数据结构的名字、使用场景。后来我发现“鄙视刷题”只是我的Imposter Syndrome，算法并不是要求我要去发明新的东西，而是需要去理解、练习。刷题就是一种高效率的学习方式



TODO List:

278, 34, 153, 650, 342, 693, 476, 371, 338, 190, 37, 785,  547, 279, 287, 257, 695, 127, 547, 216, 697, 766



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
| 16   | 566  | Reshape  the Matrix                        | brutal  force分析二维数组的i，j的相对关系                    | Array | E    | 30m      | [link](https://leetcode.com/problems/reshape-the-matrix/)    |
| 17   | 141  | Linked  List Cycle                         | 快慢指针可以重叠，边界控制                                   | Linked List    | E    | 15m      | [link](https://leetcode.com/problems/linked-list-cycle/)     |
| 18   | 2    | Add  Two Numbers                           | 方式一：遍历链表节点；方式二：利用LIFO的特性使用栈实现构造 | Linked List    | M    | 50m      | [link](https://leetcode.com/problems/add-two-numbers/)       |
| 19   | 485  | Max  Consecutive Ones                      | 太简单了，就当练习语言编程                                   | Array & Matrix | E    | 10m      |                                                              |
| 20   | 245  | Search  a 2D Matrix II                     | 从右顶点开始判断，如果当前数大于目标数则向左查找，如果当前数小于目标数则向下查找。在一个循环内就可以判断是否含有制定参数 | Array & Matrix | M    | null     | [link](https://leetcode.com/problems/search-a-2d-matrix-ii/) |
| 21   | 378  | Kth Smallest Element in a Sorted Matrix    | 方式一： 使用优先队列保存所有的元素，顺序从大到小； 方式二： 使用二分查找，左上角为最小，右下角为最大，使用范围查找确定中间值；统计范围中比中间值小的个数，对比是否大于目标k来判断左右选取范围。Time Complexity: O(log(n)) | Array & Matrix | M    | 28m       | [link](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/) |
| 22 | 645 | Set Mismatch | 方式一： Brutal Force，使用hash表统计每个数字的个数，个数为2的是出现异常的数字，遍历 1->n ，如果map不存在的就是缺失的数字。Time Complexity: O(n), Space Complexity: O(n). 方式二：使用一个新的数组保存排序排序后数字，第一次遍历转移数字，保存的数字赋值为负数，如果一个位置已经有负数，则这个数字为重复；第二次便利新数组，判断为0的数字为缺失的数字index+1。Time Complexity: O(n), Space: O(n)。相比方式一优化体现在常数级别 | Array & Matrix | E | 30m | [link](https://leetcode.com/problems/set-mismatch/) |
| 23 | 1091 | Shortest Path in Binary Matrix | BFS | Array & Matrix | M | null | [link](https://leetcode.com/problems/shortest-path-in-binary-matrix/) |
| 24 | 442 | Find All Duplicates in an Array | 记录数组中每个元素映射到index进行标记，已经标记的index就是重复的数字。一次 遍历就可以搜索出所有 O(n)。难点在于空间复杂度的优化 | Array & Matrix | M | 25m | [link](https://leetcode.com/problems/find-all-duplicates-in-an-array/) |
| 25 | 207 | Course Schedule | 课程有序问题，可以转换为有向图，判断这个图是否存在循环acycle。可以使用dfs或者bfs | Search | M | null | [link](https://leetcode.com/problems/course-schedule/) |
| 26 | 417 | Pacific Alantic Water Flow | 分别计算Pacific、Alantic可达的方块，最后统计两边都可达的方块；4个移动方向 bfs遍历可达 | Search | M | 90m | [link](https://leetcode.com/problems/pacific-atlantic-water-flow/) |
| 27 | 684 | Redundant Connection | 方式一： 遍历所有的边(edge)，判断当前是否已经可达(u->v)，如果不可达则添加的连接列表；使用dfs判断是否可达. 方式二： 使用Union Find(Algorithms chapter 1)，树的思想，Time Complexity O(n*log(n)), Space O(n) | Search | M | null | [link](https://leetcode.com/problems/redundant-connection/) |
| 28 | 131 | Palindrome Partition | 在一个字符串里面把所有可能的结果都列举出来，常见的算法有DP和DFS/BFS。这里使用DFS，preorder列举符合回文序列的子字符；最困难的点在于想清楚如何编排遍历的顺序，这里可以画树状图分析。 | Search | M | null | [link](https://leetcode.com/problems/palindrome-partitioning/) |
| 29 | 51 | N Queens | 回溯算法三步：choice: where to place a queen; constraint: each queean can't attack each other(same row, same column, same diagonal); goal: N queens placed。 | Backtracking | H | null | [n queens](https://leetcode.com/problems/n-queens/) |
| 30 | 17 | Letter Combinations of Phone Number | 几乎没有限制条件，把所有的可能结果穷举出来。 | Bactracking | M | 39m | [letter combinations](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) |
| 31 | 200 | Number of Islands | Union find 把二维数组转换为一维数组，记录union find；四个方向的查询可以使用二维数字计算 | Union Find | M | 1h | [number-of-islands](https://leetcode.com/problems/number-of-islands/) |
| 32 | 667 | Beautiful Arrangement II | 首尾向中靠拢，构造摆动 | Array | M | null | [beautiful arrangement](https://leetcode.com/problems/beautiful-arrangement-ii/) |
| 33 | 130 | Surrounded Region | 1.遍历所有边界上的region并加入queue；2.BFS queue弹出一个节点，标记，检查四个方向是否有region ，有的话就加入queue； 3.知道queue为空，检查所有的region，如果没有被标记的话就是可以flip的 | BFS | M | 40m | [surrounded region](https://leetcode.com/problems/surrounded-regions/submissions/) |
| 34 | 210 | Course Schedule II | 1.DFS-后置遍历，同时检查是否有循环 | DFS | M | 1.5h | [course schedule II](https://leetcode.com/problems/course-schedule-ii/) |
| 35 | 40 | Combination Sum II |  | Backtracking | M | null | [combination sum II](https://leetcode.com/problems/combination-sum-ii/submissions/) |
| 36 | 46 | Permutations | 多次遍历组合，枚举所有的可能组合，符合回溯的特征。 | Backtracking | M | 2h | [permutations](https://leetcode.com/problems/permutations/) |
| 37 | 79 | Word Search | 单纯使用DFS无法解决问题，再次体现回溯循环校验同一个位置不同结果的特性 | Backtracking | M | 2h | [word search](https://leetcode.com/problems/word-search/) |
| 38 | 190 | Reverse Bit | 32位数，位移、求&运算 | Bit Manipulation | E | 1h | [reverse bit](https://leetcode.com/problems/reverse-bits/submissions/) |
| 39 | 231 | Power Of Two |  | Bit Manipulation | E | 20m | [power of two](https://leetcode.com/problems/power-of-two/submissions/) |
| 40 | 769 | Max Chunk to Sort | 能被分成一个chunk的数组中的最大数字等于所在数字的位置index，然后再找下一个数组的切割位 | Array | M | 30m | max chunk to sort |
| 41 | 39 | Combination Sum |  | Backtracking | M | 1h | [combination sum](https://leetcode.com/problems/combination-sum/) |
| 42 | 47 | Permutations II |  | Backtracking | M | 25m | [permutations II](https://leetcode.com/problems/permutations-ii/) |
| 43 | 583 | Delete Operation For Two Strings |  | DP | M | 1.5h | [two strings](https://leetcode.com/problems/delete-operation-for-two-strings/) |
| 44 | 565 | Array Nesting | Brutal Force: 贪心策略，每个元素为起点统计set长度，只保留最长的len。Time Complexity O(n^2) | Array | M | 25m | [array nesting](https://leetcode.com/problems/array-nesting/) |
| 45 | 328 | Odd Even Linked List |  | Linked List | M | 2h |  |
| 46 | 318 |  | | DP | M | 40m | |
| 47 | 72 | Edit Distance | table的含义：dp(i)(j) word1的前i个字符，需要word2的前j个字符修改多少次才能相同； | DP | H | - | [edit distance](https://leetcode.com/problems/edit-distance/) |
| 48 | 77 | Combinations |  | Backtracking | M | 10m |  |
| 49 | 19 | Remove Nth Node From End | 方式一： 计数法； 方式二：递归计数，定位n+1 个节点，然后删除操作 | Linked List | M | 20m | [remove nth node](https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/) |
| 50 | 78 | Subset | topic 提示之后才写出 | Backtracking | M | 40m | [subset](https://leetcode.com/problems/subsets/) |
| 51 | 387 | Find the Duplicate Number |  | Binary Search | M |  | [find duplicate](https://leetcode.com/problems/find-the-duplicate-number/) |


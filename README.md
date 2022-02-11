# 算法分析

用来估算一个算法所需要的时间。时间复杂度是一个描述算法所需时间如何随着输入的数据量增加而增长的函数（相对增长率）。计算算法的最坏情况复杂度，记为 $T(N)$。这个函数是渐进的，所以只保留最高次项并且省略系数。

## 符号

有以下几个符号来表示时间复杂度，主要常用 $O(f(N))$ 表示。

### $O(f(N))$

表示增长的上界，最坏的情况不会超过（$\le$）函数 $f(N)$ 的增长率。

主要用的就是这个大O表示法

### $\Omega(f(N))$

表示增长的下界。

### $\Theta(f(N))$

表示增长率与指定的函数 $f(N)$ 一样。

### $o(f(N))$

$O(f(N))$ 包含了增长率与 $f(N)$ 相等的情况，$o(f(N))$ 表示 $T(N)$ 的增长率 $\lt$ $f(N)$ 的增长率。

## 简单的判断方法

### $O(1)$

常数时间，无论输入的数据有多少都消耗同样的时间，

如果没有循环，基本上就是这样。

### $O(N)$

线性时间

当有一个循环遍历输入数据，或者多个循环，但不是嵌套的情况，则消耗线性时间。

### $O(N^2)$

当多个循环嵌套在一起时，有几个循环嵌套时间复杂度就是 $O(N^几)$，

多个循环顺序相连，复杂度为最高的层次，

如果有判断出现，选择所有分支中复杂度最高的那个作为最终的结果。

### $O(\log N)$

对数时间比线性时间要快，

二分法查找就是对数时间，而顺序查找是线性时间，

欧基里德算法找最大公因式也是对数时间。

**为什么大O表示法没有前面的系数、没有底数或者没有相加？大O表示法代表的是当数据输入量增长时，算法所需时间的增长速度。所以为了方便忽略它们（其对于时间增长速度的影响远不及乘方或者取对数）。**

# 数据结构

## 线性与非线性

- 线性数据结构只有唯一的首项和末项
- 线性结构除了首项和末项外每个项都有唯一的前驱和后继
- 线性结构可以顺序储存，如数组（ArrayList），也可以链式储存，如链表（LinkedList）

一维数组、链表、栈、队列等是线性结构

多维数组、树、图等是非线性结构

## 数组 / 表

### 变长数组（ArrayList）

使用定长数组来实现变长数组，通过一个变量来记录 size，并在实际数据量超过定长数组限度时创建一个双倍长度的新定长数组。

在 push 及 get 时消耗常数时间，而在中间插入和删除消耗线性时间。。

### 链表（LinkedList）

### 单向链表（SingleLinkedList）

实现一个单链表需要 `SingleLinkedList` 和 `SingleLinkedListItem` 两个 class。因为表内的每个项目需要维护到下一个项目的引用。最后一项的 `next` 指向 `null`。

链表在中间插入和删除时效率比较高，因为不需要把所有后面的东西都挪一个位置。但是在最后插入和删除比较慢，因为得先一路找到最后一个。

### 双向链表（DoubleLinkedList）

我们可以对单链表做一点更改，让每个 `DoubleLinkedListItem` 不仅链接到它的后一个项，还链接到前一个项，并且在 `DoubleLinkedList` 类中同时包含到第一个和最后一个项的引用，这样就减少了在最后插入和删除时的开销。

表已经涵盖了栈和队列的全部功能，但在一些不需要同时访问全部元素的情况下使用栈或者队列能够更加高效。

## 栈（Stack）

栈模型中只有最顶端的元素可以访问，栈只有 push 和 pop 两种操作，分别是在栈顶添加元素以及移除并返回栈顶元素。有些时候会有 top 操作，是查看栈顶元素，但不返回它。

栈可以像 ArrayList 一样用数组存储，也可以做成链接的方式。如果做成链接，我们只需要存储到栈顶元素的引用，并在每个元素中存储对下一个元素的引用，这两种方法都很高效，并且链式存储的方式比 LinkedList 更高效。

## 队列（Queue）

只能在尾部增加元素，在头部移除元素，因此只有 enqueue 和 dequeue 两种操作。

队列用数组的方式表示的时候，一般做成环状，因为尾部被塞满的时候很可能头部已经空出一些位置，新的数据填入这些位置里，保存队列头部和尾部两个位置的指针。这样如果尾指针小于头指针，就在读到存储用的数组末尾时回到数组最前端继续读，可以跟有效的利用空间，并且插入和删除都只消耗常数时间。

尾指针指向队列尾部元素的下一个空档。

## 树（Tree）

树是一种非线性结构，每个节点可以包含子节点。

当存储普通的树时，一般每个节点维护到第一个子节点和下一个兄弟的引用。

### 二叉树（BinaryTree）

二叉树是每个节点最多只有两个子节点的树。

存储的时候每个节点维护到左子节点和右子节点的引用，也可以作为数组存储。

在二叉树的处理中涉及到很多的递归操作。

#### 二叉树的遍历（Traversal）

有三种遍历树的方式，一般使用的是第二种。

##### Preorder

先看那个节点的 value，再递归遍历左子节点和右子节点（用同样的方法）。

##### Inorder

先左子节点，然后它本身，然后右节点。

##### Postorder

先递归遍历左子节点和右子节点，再读取它本身的 value。

#### 二叉查找树（Binary Search Tree）

二叉查找树是一种特殊的二叉树，里面的项都是排列好的，可以很快的从里面查找东西，类似与二分法。（$O(\log N)$）

##### 要求

- 整个树中没有重复的 value

- 在每个节点中，左子节点（如果有） $\lt$ 它本身 $\lt$ 右子节点（如果有）

  也就是说，Inorder Traversal 下来是按顺序的

##### 搜索方式

把节点的 value 与要找的数对比一下，如果小了，那就往右分支找（递归），大了就往左分支找

一路向左走，就能找到最小值，向右走能找到最大值。这个的实现可以用递归，也可以不用

##### 插入

遍历二叉树，在最底下找到它该在的位置插入

##### 删除

如果是删除最底下的树叶节点，那么直接删掉就可以

删除有一个子节点的节点，就用它的子**节点**替换它

删除有两个子节点的节点，得找到它左支里面最大的或者右支里面最小的**数值**来代替它的**数值**

在很多情况下，在数中删除节点并不是用上面的方法删除，而是打上删除标记。如果接下来再要用到那个节点，可以直接取消那个删除标记

#### 平衡二叉树（AVL Tree）

在二叉查找树经过多次操作之后会出现不平衡的情况，效率就变低了

##### 要求

- 左右子树的高度差小于等于 1
- 其每一个子树均为平衡二叉树

##### 平衡因子

AVL 树的每一个节点都有一个平衡因子，是它的左子树高度减去右子树高度。AVL 树要求每个节点的平衡因子必须是 0 -1 1 中的一个。当不平衡时，通过旋转来使子树平衡

## 哈希表 / 散列表（Hash table）

哈希表可以保存键值对（Key Value Pair），也就是两个数据的对应关系。很多时候也叫映射（Map）或者字典（Dictionary）。调用的时候像 ArrayList 一样，但是 index 换成了 key。key 和 value 可以是任何类型

```Java
table1.get("QwQ");
table2.get(23333);
```

### 实现方法

假设是一个整数到整数的对应表，作为 key 的整数可以很大，那么做成一个很大的数组就很不现实了，而且我们还可以用别的比如说 `String` 或者 `char` 来做 key。

所以我们在哈希表里面内置一个数组，数组的长度去一个大一点的素数，拿 key 除以数组的长度得到的余数作为下标，存储到数组对应的格子里。用素数是为了保证存储的位置尽量平均分配到各个格子里

https://segmentfault.com/a/1190000023904715

## 堆

堆可以理解成一种二叉树

### 堆的构建和操作

p163

# 排序 

## 各种时间复杂度

### $O(N^2)$

- 插入排序
- 希尔排序
- 快速排序（最坏）

### $O(N \log N)$

- 堆排序
- 归并排序
- 快速排序（平均）

## 用到分治法 (Divide-and-conquer)的

- 快速排序
- 归并排序

![](https://oi-wiki.org/basic/images/sort-intro-1.gif)

# 图论算法

https://zhuanlan.zhihu.com/p/25498681

## 名词定义

- 图（graph）是由顶点和边组成的(可以无边，但至少包含一个顶点)

  V：顶点集合（vertices）

  E：边集合（edges）

- 图可以分为有向图（Directed graph，digraph）和无向图

  (v, w) 表示无向边

  <v, w> 表示有向边

- 有权图：每条边具有一定的权重(weight)

- 无权图：每条边均没有权重（或者权重都一样）

- 连通图：所有的点都有路径相连（不需要直接相连）

  在有向图中，如果两个点能双向联通叫强联通，单向叫弱联通。每个点都能强联通叫强联通图

- 非连通图：存在某两个点没有路径相连

  ![这里写图片描述](https://img-blog.csdnimg.cn/img_convert/22bf9e615be91aa518816159ea9f0fb2.png)

- 度(Degree)：所有与它连接点的个数之和

## **邻接矩阵**（Adjacency Matrix）与邻接表

邻接矩阵：

- 在 n 个顶点的图需要有一个 n × n 大小的矩阵
- 在一个无权图中，矩阵坐标中每个位置值为 1 代表两个点是相连的，0 表示两点是不相连的
- 在一个有权图中，矩阵坐标中每个位置值代表该两点之间的权重，0 表示该两点不相连
- 在无向图中，邻接矩阵关于对角线相等

邻接表：

对于每一个顶点都保存一个它能到哪里去的链表

![img](https://pic1.zhimg.com/80/v2-97b58740d45f3041736d45faacbbfb94_720w.png)

![img](https://pic1.zhimg.com/80/v2-a0a7be239901e18c1b3ff2195d2d7450_720w.png)

行标题：从哪里来

列标题：到哪里去

## 遍历方式

https://juejin.cn/post/6844903807759941646

### **深度优先遍历：(Depth First Search, DFS)**

有点像树的遍历

从初始点出发，不断向前走，如果碰到死路了，就往回走一步，尝试另一条路，直到发现了目标位置。这种不撞南墙不回头的方法，即使成功也不一定找到一条好路，但好处是需要记住的位置比较少。

### **广度优先遍历：(Breadth First Search, BFS)**

从初始点出发，把所有一步能够到的路径都走一遍，如果里面没有目标位置，则尝试把所有两步能够到的位置都走一遍，看有没有目标位置；如果还不行，则尝试所有三步可以到的位置。这种方法，一定可以找到一条最短路径，但需要记忆的内容实在很多，要量力而行。

## 最短路径算法 (Shortest Path Algorithm)

### 单源最短路径

#### 无权最短路径

#### Dijkstra 算法

用于加权图，但必须是非负权图

## 最小生成树 (Minimum Spanning Trees MST)

![img](https://pic2.zhimg.com/80/v2-a5c14efbff6176183849d33a2041db31_720w.png)

# fast-functional-programming
快速入门 - Java8函数式编程


### 功能演示主类：TradeServiceTest

### -----------------------------函数式编程常用函数-----------------------------
|API                |API描述                                                 |对应例子主类
| ------ | ------ | ------ |
|1. 过滤、返回值等:
|filter()            |筛选                                                   |Filter, Search
|map()               |映射到新对象                                            |ArraysOperation
|flatMap()           |切换成新的流                                            |ArraysOperation
|reduce()            |将List<T>变成1个元素                                    |StringJoin, StringJoin2
|collect()           |返回值                                                 |GroupBy
|forEach()           |遍历                                                   |HelloWorld
|  |  |  |
|2. 分组              |                                                       |
|groupingBy          |分组                                                   |GroupBy
|partitionBy         |将List<T>分成两个子List<T>                              |PartitionBy
|counting()          |记录数                                                 |GroupBy
|toList()            |List<T>                                               |GroupBy
|toSet()             |Set<T>                                                |GroupBy
|toMap()             |Map<K,V>                                              |ToMap
|mapToDouble()       |映射成double类型                                        |MinMaxAvgSum
|summaryStatistics() |数据分析,获取min, max, avg, sum                         |MinMaxAvgSum
|  |  |  |                                                                           
|3. 排序              |                                                       |
|sorted()            |排序(默认为升序)                                         |OrderBy
|reversed()          |倒序(与原顺序相反)                                       |OrderBy
|reversedOrder()     |倒序                                                    |OrderBy
|  |  |  |
|4. 查找              |                                                       |
|findFirst()         |查找第一个匹配的元素(找不到返回false)                      |Search
|findAny()           |查找满足条件的任意一个                                    |Search
|orElse()            |未满足条件时取指定值                                      |Search
|orElseGet()         |未满足条件时取生成的值                                    |IfElseCheck
|orElseThrow()       |取第一个失败时抛出异常                                    |Search
|skip()              |跳过N条记录                                             |Search
|limit()             |取前N条记录                                             |Search


### -----------------------------常用案例-----------------------------
|类名                         |功能描述
| ------ | ------ |
|1. GetAndSetFieldValue      |多属性赋值优化
|2. DateIterator             |循环优化
|3. IfElseCheck              |if-else判断优化
|4. NullOptional             |空值判断优化
|5. Break                    |for循环中的break,continue转换

### 设计模式内容来自于书籍：https://item.jd.com/11673259.html

# LeetCode 项目约定

Maven + JUnit 5 (Java 21)。每道题一个包:`leetcode.pNNNN_<snake_case_title>`,
源码在 `src/main/java/...`,测试在 `src/test/java/...`(包名相同)。

## 录题时
- `Solution.java` 用题目给的方法签名,方法体只放占位(`return null;` / 空),
  **不写任何解法、不给提示**——用户自己实现。
- 同步建 `SolutionTest.java`,把题目的所有示例(Example)作为用例补进去。
- 同一道题如需多种写法,新建 `Solution2`、`Solution3` 等,各配 `Solution2Test` 等。

## 测试断言约定(重要)
输出是数组 / 链表 / 集合类时,**不要用 `assertArrayEquals`**——它失败时只报某个下标的单值
(`array contents differ at index [3], Expected :3 Actual :5`),看不到整体。

改为把结果转成 `List<Integer>`,用 `assertEquals(List.of(...), toList(...))`,
失败时会直接打印两条完整列表:
```
Expected :[1, 2, 2, 3, 5, 6]
Actual   :[1, 2, 2, 5, 3, 6]
```

辅助方法(按数据结构二选一,放在测试类里):
```java
// 数组
private static List<Integer> toList(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int num : nums) result.add(num);
    return result;
}

// 链表(配套 build(int...) 构造输入)
private static List<Integer> toList(ListNode node) {
    List<Integer> result = new ArrayList<>();
    for (ListNode n = node; n != null; n = n.next) result.add(n.val);
    return result;
}
```
原地修改类题目(如 #88,`void merge(...)`)就断言被修改的入参数组。

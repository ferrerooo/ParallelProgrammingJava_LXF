
/*

c#中类似的功能：https://github.com/ferrerooo/ParallelProgrammingCSharp/blob/main/S5_34ThreadLocalStorage.cs

 * 
 * 这种在一个线程中，横跨若干方法调用，需要传递的对象，我们通常称之为上下文（Context），它是一种状态，可以是用户身份、任务信息等。

给每个方法增加一个context参数非常麻烦，而且有些时候，如果调用链有无法修改源码的第三方库，User对象就传不进去了。

Java标准库提供了一个特殊的ThreadLocal，它可以在一个线程中传递同一个对象。
 * 
*/
public class S20_TheadLocal {
    
}
package org.clb.io.nio;

/**
 * 使用Buffer读写数据一般遵循以下四个步骤：
 * 1.写入数据到Buffer
 * 2.调用flip()方法
 * 3.从Buffer中读取数据
 * 4.调用clear()方法或者compact()方法
 *  clear(): 清空整个缓冲区
 *  compact(): 只会清除已经读过的数据
 */
public class BufferTest {
}

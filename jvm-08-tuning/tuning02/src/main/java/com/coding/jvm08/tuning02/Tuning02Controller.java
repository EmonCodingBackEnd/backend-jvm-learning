package com.coding.jvm08.tuning02;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.*;

@RestController
@RequiredArgsConstructor
public class Tuning02Controller {

    @RequestMapping("/getData")
    public Void visit() {
        // 1、创建线程池
        int count = 7;
        ThreadFactory builder = new CustomizableThreadFactory("BizThreadPool-%d");
        ExecutorService executorService = new ThreadPoolExecutor(count, count, 2, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), builder);

        // 模拟获取商品信息
        CompletableFuture<Object> productList =
                CompletableFuture.supplyAsync(
                        () -> {
                            while (true) {
                            }
                        },
                        executorService);

        // 模拟获取商品价格
        CompletableFuture<Object> productPrice = CompletableFuture.supplyAsync(
                () -> {
                    for (int i = 0; i < Long.MAX_VALUE; i++) {
                        System.out.println("商品价格为： " + 10 + " 元");
                        try {
                            // 模拟 I/O 等待、切换
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    return null;
                },
                executorService);

        // 模拟获取商品分类信息
        CompletableFuture<Object> productClassify = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
            }
            System.out.println("商品分类为：电子商品");
            return null;
        }, executorService);

        CompletableFuture.anyOf(productList, productPrice, productClassify).join();
        return null;
    }
}

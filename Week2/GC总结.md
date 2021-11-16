#串行GC：
```
D:\IdeaProject\jvm\src\main\java\com\geektime\week1>java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseSerialGC GCLogAnalysis
正在执行...
2021-11-17T01:40:41.356+0800: [GC (Allocation Failure) 2021-11-17T01:40:41.357+0800: [DefNew: 279616K->34944K(314560K), 0.0564782 secs] 279616K->83694K(1013632K), 0.0581237 secs] [Times: user=0.03 sys=0.02, real=0.06 secs]
2021-11-17T01:40:41.454+0800: [GC (Allocation Failure) 2021-11-17T01:40:41.454+0800: [DefNew: 314287K->34942K(314560K), 0.0683975 secs] 363038K->172009K(1013632K), 0.0691495 secs] [Times: user=0.03 sys=0.03, real=0.07 secs]
2021-11-17T01:40:41.560+0800: [GC (Allocation Failure) 2021-11-17T01:40:41.566+0800: [DefNew: 314558K->34943K(314560K), 0.0452186 secs] 451625K->246074K(1013632K), 0.0459047 secs] [Times: user=0.03 sys=0.02, real=0.05 secs]
2021-11-17T01:40:41.642+0800: [GC (Allocation Failure) 2021-11-17T01:40:41.648+0800: [DefNew: 314559K->34943K(314560K), 0.0414949 secs] 525690K->314379K(1013632K), 0.0422777 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2021-11-17T01:40:41.720+0800: [GC (Allocation Failure) 2021-11-17T01:40:41.723+0800: [DefNew: 314559K->34943K(314560K), 0.0453116 secs] 593995K->393839K(1013632K), 0.0459512 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2021-11-17T01:40:41.800+0800: [GC (Allocation Failure) 2021-11-17T01:40:41.806+0800: [DefNew: 314209K->34943K(314560K), 0.0458278 secs] 673104K->471363K(1013632K), 0.0465497 secs] [Times: user=0.02 sys=0.01, real=0.05 secs]
2021-11-17T01:40:41.884+0800: [GC (Allocation Failure) 2021-11-17T01:40:41.889+0800: [DefNew: 314559K->34943K(314560K), 0.0490307 secs] 750979K->555500K(1013632K), 0.0498392 secs] [Times: user=0.03 sys=0.02, real=0.05 secs]
2021-11-17T01:40:41.976+0800: [GC (Allocation Failure) 2021-11-17T01:40:41.978+0800: [DefNew: 314559K->34943K(314560K), 0.0472534 secs] 835116K->636546K(1013632K), 0.0481946 secs] [Times: user=0.01 sys=0.01, real=0.05 secs]
2021-11-17T01:40:42.058+0800: [GC (Allocation Failure) 2021-11-17T01:40:42.059+0800: [DefNew: 314559K->34944K(314560K), 0.0536163 secs] 916162K->716285K(1013632K), 0.0544683 secs] [Times: user=0.03 sys=0.02, real=0.05 secs]
2021-11-17T01:40:42.151+0800: [GC (Allocation Failure) 2021-11-17T01:40:42.155+0800: [DefNew: 314560K->314560K(314560K), 0.0006609 secs]2021-11-17T01:40:42.156+0800: [Tenured: 681341K->380546K(699072K), 0.0712218 secs] 995901K->380546K(1013632K), [Metaspace: 2632K->2632K(1056768K)], 0.0766468 secs] [Times: user=0.06 sys=0.00, real=0.08 secs]
执行结束!共生成对象次数:10646
Heap
 def new generation   total 314560K, used 11885K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
  eden space 279616K,   4% used [0x00000000c0000000, 0x00000000c0b9b4a8, 0x00000000d1110000)
  from space 34944K,   0% used [0x00000000d3330000, 0x00000000d3330000, 0x00000000d5550000)
  to   space 34944K,   0% used [0x00000000d1110000, 0x00000000d1110000, 0x00000000d3330000)
 tenured generation   total 699072K, used 380546K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
   the space 699072K,  54% used [0x00000000d5550000, 0x00000000ec8f0b50, 0x00000000ec8f0c00, 0x0000000100000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```
-串行GC在年轻代垃圾回收使用的是标记-复制算法，老年代使用的是标记-清除-整理算法，发生GC时会导致STW，不能充分利用多核CPU，
 适合在单核CPU且几百M的堆内存时使用。


#并行GC： 
```
 D:\IdeaProject\jvm\src\main\java\com\geektime\week1>java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseParallelGC GCLogAnalysis
正在执行...
2021-11-17T01:58:02.950+0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43506K(305664K)] 262144K->78631K(1005056K), 0.0134747 secs] [Times: user=0.05 sys=0.08, real=0.02 secs]
2021-11-17T01:58:03.004+0800: [GC (Allocation Failure) [PSYoungGen: 305650K->43519K(305664K)] 340775K->153558K(1005056K), 0.0202946 secs] [Times: user=0.08 sys=0.06, real=0.02 secs]
2021-11-17T01:58:03.056+0800: [GC (Allocation Failure) [PSYoungGen: 305663K->43513K(305664K)] 415702K->221440K(1005056K), 0.0161667 secs] [Times: user=0.03 sys=0.03, real=0.02 secs]
2021-11-17T01:58:03.106+0800: [GC (Allocation Failure) [PSYoungGen: 305657K->43515K(305664K)] 483584K->289430K(1005056K), 0.0169600 secs] [Times: user=0.02 sys=0.09, real=0.02 secs]
2021-11-17T01:58:03.162+0800: [GC (Allocation Failure) [PSYoungGen: 305659K->43518K(305664K)] 551574K->365957K(1005056K), 0.0180523 secs] [Times: user=0.03 sys=0.09, real=0.02 secs]
2021-11-17T01:58:03.215+0800: [GC (Allocation Failure) [PSYoungGen: 305662K->43508K(160256K)] 628101K->430276K(859648K), 0.0164354 secs] [Times: user=0.03 sys=0.06, real=0.02 secs]
2021-11-17T01:58:03.245+0800: [GC (Allocation Failure) [PSYoungGen: 160244K->74116K(232960K)] 547012K->468081K(932352K), 0.0106715 secs] [Times: user=0.13 sys=0.00, real=0.02 secs]
2021-11-17T01:58:03.274+0800: [GC (Allocation Failure) [PSYoungGen: 190852K->93912K(232960K)] 584817K->498280K(932352K), 0.0123938 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
2021-11-17T01:58:03.324+0800: [GC (Allocation Failure) [PSYoungGen: 210648K->102518K(232960K)] 615016K->523811K(932352K), 0.0151812 secs] [Times: user=0.00 sys=0.01, real=0.02 secs]
2021-11-17T01:58:03.356+0800: [GC (Allocation Failure) [PSYoungGen: 219254K->71129K(232960K)] 640547K->552287K(932352K), 0.0158373 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-11-17T01:58:03.390+0800: [GC (Allocation Failure) [PSYoungGen: 187865K->38211K(232960K)] 669023K->583075K(932352K), 0.0140929 secs] [Times: user=0.08 sys=0.05, real=0.01 secs]
2021-11-17T01:58:03.412+0800: [GC (Allocation Failure) [PSYoungGen: 154947K->39639K(232960K)] 699811K->618506K(932352K), 0.0132031 secs] [Times: user=0.09 sys=0.03, real=0.02 secs]
2021-11-17T01:58:03.442+0800: [GC (Allocation Failure) [PSYoungGen: 156375K->39883K(232960K)] 735242K->654467K(932352K), 0.0125577 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-11-17T01:58:03.462+0800: [Full GC (Ergonomics) [PSYoungGen: 39883K->0K(232960K)] [ParOldGen: 614583K->327924K(699392K)] 654467K->327924K(932352K), [Metaspace: 2632K->2632K(1056768K)], 0.0527393 secs] [Times: user=0.23 sys=0.01, real=0.05 secs]
2021-11-17T01:58:03.533+0800: [GC (Allocation Failure) [PSYoungGen: 116638K->42474K(232960K)] 444562K->370398K(932352K), 0.0059479 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2021-11-17T01:58:03.555+0800: [GC (Allocation Failure) [PSYoungGen: 159210K->44147K(232960K)] 487134K->406573K(932352K), 0.0098266 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
2021-11-17T01:58:03.590+0800: [GC (Allocation Failure) [PSYoungGen: 160883K->33609K(232960K)] 523309K->435964K(932352K), 0.0096448 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-11-17T01:58:03.617+0800: [GC (Allocation Failure) [PSYoungGen: 149998K->37795K(232960K)] 552352K->470754K(932352K), 0.0096578 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
2021-11-17T01:58:03.640+0800: [GC (Allocation Failure) [PSYoungGen: 154531K->40751K(232960K)] 587490K->506602K(932352K), 0.0083953 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-11-17T01:58:03.691+0800: [GC (Allocation Failure) [PSYoungGen: 157487K->39789K(232960K)] 623338K->542769K(932352K), 0.0095447 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-11-17T01:58:03.722+0800: [GC (Allocation Failure) [PSYoungGen: 156170K->39964K(232960K)] 659150K->576641K(932352K), 0.0101073 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2021-11-17T01:58:03.748+0800: [GC (Allocation Failure) [PSYoungGen: 156700K->34991K(232960K)] 693377K->608153K(932352K), 0.0108917 secs] [Times: user=0.13 sys=0.00, real=0.01 secs]
2021-11-17T01:58:03.773+0800: [GC (Allocation Failure) [PSYoungGen: 151727K->39545K(232960K)] 724889K->643310K(932352K), 0.0094687 secs] [Times: user=0.00 sys=0.02, real=0.02 secs]
执行结束!共生成对象次数:13192
Heap
 PSYoungGen      total 232960K, used 44415K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 116736K, 4% used [0x00000000eab00000,0x00000000eafc1980,0x00000000f1d00000)
  from space 116224K, 34% used [0x00000000f8e80000,0x00000000fb51e518,0x0000000100000000)
  to   space 116224K, 0% used [0x00000000f1d00000,0x00000000f1d00000,0x00000000f8e80000)
 ParOldGen       total 699392K, used 603765K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 86% used [0x00000000c0000000,0x00000000e4d9d558,0x00000000eab00000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```
-并行GC在年轻代垃圾回收使用的是标记-复制算法，老年代使用的是标记-清除-整理算法，发生GC时会导致STW，可以多线程并行回收垃圾，
 适合吞吐量大的系统，但不一定能够减少GC暂停时间，在不需要GC的时候，不会消耗任何资源，并行GC为java8的默认GC。
 
 
#CMSGC： 
``` 
D:\IdeaProject\jvm\src\main\java\com\geektime\week1>java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseConcMarkSweepGC GCLogAnalysis
正在执行...
2021-11-17T02:04:38.572+0800: [GC (Allocation Failure) 2021-11-17T02:04:38.576+0800: [ParNew: 279616K->34944K(314560K), 0.0255567 secs] 279616K->86395K(1013632K), 0.0267183 secs] [Times: user=0.01 sys=0.09, real=0.03 secs]
2021-11-17T02:04:38.639+0800: [GC (Allocation Failure) 2021-11-17T02:04:38.643+0800: [ParNew: 314468K->34944K(314560K), 0.0213431 secs] 365920K->169216K(1013632K), 0.0222775 secs] [Times: user=0.03 sys=0.08, real=0.03 secs]
2021-11-17T02:04:38.694+0800: [GC (Allocation Failure) 2021-11-17T02:04:38.700+0800: [ParNew: 314560K->34944K(314560K), 0.0516407 secs] 448832K->252503K(1013632K), 0.0525863 secs] [Times: user=0.31 sys=0.03, real=0.06 secs]
2021-11-17T02:04:38.781+0800: [GC (Allocation Failure) 2021-11-17T02:04:38.786+0800: [ParNew: 314560K->34944K(314560K), 0.0590506 secs] 532119K->338614K(1013632K), 0.0596505 secs] [Times: user=0.36 sys=0.02, real=0.06 secs]
2021-11-17T02:04:38.879+0800: [GC (Allocation Failure) 2021-11-17T02:04:38.880+0800: [ParNew: 314560K->34944K(314560K), 0.0457468 secs] 618230K->410459K(1013632K), 0.0460438 secs] [Times: user=0.30 sys=0.03, real=0.05 secs]
2021-11-17T02:04:38.926+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 375515K(699072K)] 411059K(1013632K), 0.0008815 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-11-17T02:04:38.927+0800: [CMS-concurrent-mark-start]
2021-11-17T02:04:38.930+0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2021-11-17T02:04:38.931+0800: [CMS-concurrent-preclean-start]
2021-11-17T02:04:38.933+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-11-17T02:04:38.933+0800: [CMS-concurrent-abortable-preclean-start]
2021-11-17T02:04:38.955+0800: [GC (Allocation Failure) 2021-11-17T02:04:38.962+0800: [ParNew: 314560K->34943K(314560K), 0.0535553 secs] 690075K->496632K(1013632K), 0.0540253 secs] [Times: user=0.34 sys=0.03, real=0.06 secs]
2021-11-17T02:04:39.046+0800: [GC (Allocation Failure) 2021-11-17T02:04:39.053+0800: [ParNew: 314559K->34944K(314560K), 0.0508074 secs] 776248K->578051K(1013632K), 0.0513110 secs] [Times: user=0.33 sys=0.06, real=0.06 secs]
2021-11-17T02:04:39.137+0800: [GC (Allocation Failure) 2021-11-17T02:04:39.138+0800: [ParNew: 314560K->34943K(314560K), 0.0508477 secs] 857667K->658693K(1013632K), 0.0513115 secs] [Times: user=0.33 sys=0.03, real=0.05 secs]
2021-11-17T02:04:39.223+0800: [GC (Allocation Failure) 2021-11-17T02:04:39.223+0800: [ParNew: 314559K->314559K(314560K), 0.0001786 secs]2021-11-17T02:04:39.223+0800: [CMS2021-11-17T02:04:39.227+0800: [CMS-concurrent-abortable-preclean: 0.008/0.294 secs] [Times: user=1.11 sys=0.13, real=0.29 secs]
 (concurrent mode failure): 623749K->352711K(699072K), 0.0614284 secs] 938309K->352711K(1013632K), [Metaspace: 2632K->2632K(1056768K)], 0.0621581 secs] [Times: user=0.05 sys=0.00, real=0.06 secs]
2021-11-17T02:04:39.321+0800: [GC (Allocation Failure) 2021-11-17T02:04:39.330+0800: [ParNew: 279616K->34943K(314560K), 0.0138472 secs] 632327K->443991K(1013632K), 0.0148176 secs] [Times: user=0.13 sys=0.00, real=0.02 secs]
2021-11-17T02:04:39.345+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 409047K(699072K)] 449573K(1013632K), 0.0014420 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-11-17T02:04:39.347+0800: [CMS-concurrent-mark-start]
2021-11-17T02:04:39.349+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-11-17T02:04:39.350+0800: [CMS-concurrent-preclean-start]
2021-11-17T02:04:39.352+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2021-11-17T02:04:39.352+0800: [CMS-concurrent-abortable-preclean-start]
2021-11-17T02:04:39.381+0800: [GC (Allocation Failure) 2021-11-17T02:04:39.382+0800: [ParNew: 314559K->34943K(314560K), 0.0179036 secs] 723607K->528536K(1013632K), 0.0188091 secs] [Times: user=0.14 sys=0.00, real=0.02 secs]
执行结束!共生成对象次数:12386
Heap
 par new generation   total 314560K, used 211428K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
  eden space 279616K,  63% used [0x00000000c0000000, 0x00000000cac59540, 0x00000000d1110000)
  from space 34944K,  99% used [0x00000000d1110000, 0x00000000d332fc80, 0x00000000d3330000)
  to   space 34944K,   0% used [0x00000000d3330000, 0x00000000d3330000, 0x00000000d5550000)
 concurrent mark-sweep generation total 699072K, used 493593K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K 
```
-CMSGC在年轻代垃圾回收使用的是标记-复制算法（并行STW），老年代使用的是标记-清除算法（并发），不对老年代进行整理，在标记-清除阶段与应用线程并发执行，
 默认为CPU核心数的四分之一，GC暂停时间短，但同时也会造成老年代内存碎片化的问题。


#G1GC： 
``` 
D:\IdeaProject\jvm\src\main\java\com\geektime\week1>java -XX:+PrintGC -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseG1GC GCLogAnalysis
正在执行...
2021-11-17T02:13:10.782+0800: [GC pause (G1 Evacuation Pause) (young) 67M->26M(1024M), 0.0059910 secs]
2021-11-17T02:13:10.800+0800: [GC pause (G1 Evacuation Pause) (young) 80M->45M(1024M), 0.0074425 secs]
2021-11-17T02:13:10.822+0800: [GC pause (G1 Evacuation Pause) (young) 95M->60M(1024M), 0.0054086 secs]
2021-11-17T02:13:10.844+0800: [GC pause (G1 Evacuation Pause) (young) 136M->88M(1024M), 0.0084071 secs]
2021-11-17T02:13:11.233+0800: [GC pause (G1 Evacuation Pause) (young)-- 860M->557M(1024M), 0.0137155 secs]
2021-11-17T02:13:11.247+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 558M->556M(1024M), 0.0089372 secs]
2021-11-17T02:13:11.256+0800: [GC concurrent-root-region-scan-start]
2021-11-17T02:13:11.257+0800: [GC concurrent-root-region-scan-end, 0.0008708 secs]
2021-11-17T02:13:11.260+0800: [GC concurrent-mark-start]
2021-11-17T02:13:11.264+0800: [GC concurrent-mark-end, 0.0041470 secs]
2021-11-17T02:13:11.271+0800: [GC remark, 0.0042879 secs]
2021-11-17T02:13:11.275+0800: [GC cleanup 632M->631M(1024M), 0.0072960 secs]
2021-11-17T02:13:11.283+0800: [GC concurrent-cleanup-start]
2021-11-17T02:13:11.284+0800: [GC concurrent-cleanup-end, 0.0007192 secs]
2021-11-17T02:13:11.333+0800: [GC pause (G1 Evacuation Pause) (young)-- 927M->835M(1024M), 0.0047583 secs]
2021-11-17T02:13:11.366+0800: [GC pause (G1 Evacuation Pause) (mixed) 897M->753M(1024M), 0.0087630 secs]
2021-11-17T02:13:11.390+0800: [GC pause (G1 Evacuation Pause) (mixed) 806M->671M(1024M), 0.0083225 secs]
2021-11-17T02:13:11.409+0800: [GC pause (G1 Evacuation Pause) (mixed) 728M->597M(1024M), 0.0077864 secs]
2021-11-17T02:13:11.426+0800: [GC pause (G1 Evacuation Pause) (mixed) 651M->597M(1024M), 0.0059807 secs]
2021-11-17T02:13:11.435+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 607M->597M(1024M), 0.0065428 secs]
2021-11-17T02:13:11.442+0800: [GC concurrent-root-region-scan-start]
2021-11-17T02:13:11.443+0800: [GC concurrent-root-region-scan-end, 0.0008392 secs]
2021-11-17T02:13:11.444+0800: [GC concurrent-mark-start]
2021-11-17T02:13:11.448+0800: [GC concurrent-mark-end, 0.0041156 secs]
2021-11-17T02:13:11.448+0800: [GC remark, 0.0088183 secs]
2021-11-17T02:13:11.458+0800: [GC cleanup 626M->586M(1024M), 0.0045660 secs]
2021-11-17T02:13:11.462+0800: [GC concurrent-cleanup-start]
2021-11-17T02:13:11.463+0800: [GC concurrent-cleanup-end, 0.0007406 secs]
2021-11-17T02:13:11.504+0800: [GC pause (G1 Evacuation Pause) (young) 839M->629M(1024M), 0.0099060 secs]
2021-11-17T02:13:11.519+0800: [GC pause (G1 Evacuation Pause) (mixed) 655M->538M(1024M), 0.0085384 secs]
2021-11-17T02:13:11.537+0800: [GC pause (G1 Evacuation Pause) (mixed) 589M->466M(1024M), 0.0077575 secs]
2021-11-17T02:13:11.556+0800: [GC pause (G1 Evacuation Pause) (mixed) 522M->432M(1024M), 0.0070103 secs]
2021-11-17T02:13:11.565+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 437M->432M(1024M), 0.0187175 secs]
2021-11-17T02:13:11.584+0800: [GC concurrent-root-region-scan-start]
2021-11-17T02:13:11.588+0800: [GC concurrent-root-region-scan-end, 0.0040251 secs]
2021-11-17T02:13:11.593+0800: [GC concurrent-mark-start]
2021-11-17T02:13:11.597+0800: [GC concurrent-mark-end, 0.0045116 secs]
2021-11-17T02:13:11.603+0800: [GC remark, 0.0036315 secs]
2021-11-17T02:13:11.606+0800: [GC cleanup 507M->495M(1024M), 0.0025006 secs]
2021-11-17T02:13:11.609+0800: [GC concurrent-cleanup-start]
2021-11-17T02:13:11.614+0800: [GC concurrent-cleanup-end, 0.0048356 secs]
2021-11-17T02:13:11.661+0800: [GC pause (G1 Evacuation Pause) (young)-- 837M->573M(1024M), 0.0122712 secs]
2021-11-17T02:13:11.676+0800: [GC pause (G1 Evacuation Pause) (mixed) 584M->517M(1024M), 0.0110520 secs]
2021-11-17T02:13:11.688+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 523M->519M(1024M), 0.0045131 secs]
2021-11-17T02:13:11.694+0800: [GC concurrent-root-region-scan-start]
2021-11-17T02:13:11.695+0800: [GC concurrent-root-region-scan-end, 0.0018714 secs]
2021-11-17T02:13:11.696+0800: [GC concurrent-mark-start]
2021-11-17T02:13:11.700+0800: [GC concurrent-mark-end, 0.0042470 secs]
2021-11-17T02:13:11.701+0800: [GC remark, 0.0036013 secs]
2021-11-17T02:13:11.705+0800: [GC cleanup 555M->548M(1024M), 0.0101002 secs]
2021-11-17T02:13:11.716+0800: [GC concurrent-cleanup-start]
2021-11-17T02:13:11.723+0800: [GC concurrent-cleanup-end, 0.0074941 secs]
执行结束!共生成对象次数:9606
```
-G1GC堆不再分成年轻代跟老年代，而是划分为多个小块区域，不会每次都收集处理整个堆空间，而是增量的方式来做垃圾回收，每次只处理一部分，
 优先处理垃圾最多的小块，GC暂停时间短，每次GC暂停都会处理所有年轻代的小块，跟部分老年代小块，但在产生FullGC时会退化为串行GC，程序
 基本崩溃。 
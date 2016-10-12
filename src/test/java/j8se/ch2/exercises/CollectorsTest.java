package j8se.ch2.exercises;

import org.junit.Before;
import org.junit.Test;
import scala.Tuple3;
import scala.Tuple4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsTest {

    private List<Tuple4<Long, Long, String, Short>> srcTuples;

    private String nodePath1 = "/src/node1",
            nodePath2 = "/src/node2";


    @Before
    public void setUp() throws Exception {
        srcTuples = new ArrayList<>(4);
        srcTuples.add(new Tuple4<>(1L, 11L, nodePath1, (short) 2));
        srcTuples.add(new Tuple4<>(2L, 12L, nodePath1, (short) 2));
        srcTuples.add(new Tuple4<>(3L, 21L, nodePath2, (short) 3));
        srcTuples.add(new Tuple4<>(4L, 22L, nodePath2, (short) 3));
    }

    @Test
    public void conv1() throws Exception {
        Map<String, List<Tuple4>> stringTuple3Map = srcTuples.stream()
                .collect(Collectors.groupingBy(Tuple4::_3, Collectors.toList()));

        stringTuple3Map.keySet().forEach(key -> {
            System.out.print(key + ":" + stringTuple3Map.get(key));
            System.out.println();
        });
    }


    @Test
    public void conv2() throws Exception {
        Map<String, List<Tuple3<Long, Long, Short>>> map = srcTuples.stream().collect(
                Collectors.groupingBy(Tuple4::_3,
                        Collectors.mapping(o -> new Tuple3<>(o._1(), o._2(), o._4()), Collectors.toList()))
        );


    }


    @Test
    public void conv3() throws Exception {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, List<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toList())
                        )
                );

        System.out.println(result);

    }

    private class Item {

        private String name;
        private int qty;
        private BigDecimal price;

        public Item(String name, int qty, BigDecimal price) {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getQty() {
            return qty;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }
}


Here's a table summarizing the different sorting methods using lambda expressions:

| **Use Case**                                         | **Sorting Crit**                                                                                      | **Lambda Expression**                                                                                    |
| :--------------------------------------------------------- | :---------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| **Ascending Order by<br /> Integer<br /> Field**    | Integer field<br /> in ascending<br /> order                                                                | `people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));`                                        |
| **Ascending Order <br />by String<br /> Field**      | String field<br />in ascending<br /> order                                                                  | `people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));`                                             |
| **2D Array <br />Ascending <br />by First Element**  | First element<br /> of 2D array <br />in ascending<br /> order                                              | `Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));`                                                 |
| **Descending <br />Order <br />by Integer Field**    | Integer field<br />in descending<br /> order                                                                | `people.sort((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()));`                                        |
| **Descending <br />Order<br /> by String Field**     | String field<br /> in descending <br />order                                                                | `people.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));`                                             |
| **2D Array<br /> Descending <br />by First Element** | First element<br />of 2D array in <br />descending order                                                    | `Arrays.sort(array, (a, b) -> Integer.compare(b[0], a[0]));`                                                 |
| **PriorityQueue<br /> with Custom <br />Comparator** | Sort by frequency<br /> (ascending) <br />and value<br /> (descending)<br /> if frequencies <br />are equal | `pq = new PriorityQueue<>((a, b) -> a.get(0).equals(b.get(0)) ? b.get(1) - a.get(1) : a.get(0) - b.get(0));` |
|                                                            |                                                                                                             |                                                                                                                |

This table provides a concise overview of sorting criteria and their corresponding lambda expressions in Java.

1.

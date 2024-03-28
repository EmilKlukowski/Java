import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {


		knnClasifier(readTestSet("D:\\Users\\Emil\\FlowersKNNClasification\\src\\testSet.txt"), readTrainSet("D:\\Users\\Emil\\FlowersKNNClasification\\src\\trainSet.txt"), 2);


		//WCZYTYWANIE KWIATKÓW OD UŻYTKOWNIKA
		Scanner scanner = new Scanner(System.in);
		ArrayList<ArrayList<Double>> dataList = new ArrayList<>();
		String number ="";

		while (true) {
			ArrayList<Double> numbers = new ArrayList<>();

			for (int i = 0; i < 4; i++) {
				System.out.println("Podaj daną nr " + (i + 1) + " (lub -1, aby zakończyć):");
				number = scanner.next();
				if (number.equals("-1")) {
					break;
				}
				numbers.add(Double.parseDouble(number));
			}

			if (number.equals("-1")) {
				break;
			}

			dataList.add(numbers);
		}

		knnClasifier(dataList, readTrainSet("D:\\Users\\Emil\\FlowersKNNClasification\\src\\trainSet.txt"), 30);
	}

	public static void knnClasifier(ArrayList<ArrayList<Double>> testSet, HashMap<String, ArrayList<ArrayList<Double>>> trainSet, int k) {


		HashMap<ArrayList<Double>, TreeMap<Double, String>> outputDistances = measureDistances(testSet, trainSet);

		HashMap<ArrayList<Double>, TreeMap<String, Integer>> countNeighbors = countKNearestNeighbors(outputDistances, k);

		printNearestNeighborAndAccuracy(testSet, countNeighbors);
	}

	public static ArrayList<ArrayList<Double>> readTestSet(String filePath) {
		ArrayList<ArrayList<Double>> dataToTest = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			String line;
			while ((line = br.readLine()) != null) {
				ArrayList<Double> oneLine = new ArrayList<>();
				String[] fullLine = line.split(";");
				for (String oneData : fullLine) {
					oneLine.add(Double.parseDouble(oneData));
				}

				dataToTest.add(oneLine);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return dataToTest;
	}

	public static HashMap<String, ArrayList<ArrayList<Double>>> readTrainSet(String filePath) {

		HashMap<String, ArrayList<ArrayList<Double>>> trainSet = new HashMap<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			String line;
			while ((line = br.readLine()) != null) {
				String[] fullLine = line.split(";");

				ArrayList<Double> dataFromOneLine = new ArrayList<>();

				for (int i = 0; i < fullLine.length - 1; i++) {
					dataFromOneLine.add(Double.parseDouble(fullLine[i]));
				}

				ArrayList<ArrayList<Double>> data = new ArrayList<>();
				data.add(dataFromOneLine);

				if (!trainSet.containsKey(fullLine[fullLine.length - 1])) {
					trainSet.put(fullLine[fullLine.length - 1], data);
				} else {
					trainSet.get(fullLine[fullLine.length - 1]).add(dataFromOneLine);
				}
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		return trainSet;
	}


	/**
	 * @measureDistances Funkcja przyjmuje:
	 * testSet: [6.3;3.3;6.0;2.5;
	 * 4.9;3.0;1.4;0.2;
	 * 4.7;3.2;1.3;0.2;]
	 * trainSet: Key: "Iris-Setosa" Value:
	 * [
	 * [5.1, 3.5, 1.4, 0.2]
	 * [4.9, 3.0, 1.4, 0.2]
	 * [4.7, 3.2, 1.3, 0.2]
	 * ...]
	 * <p>
	 * Funkcja zwraca posortowane rosnąco odległości od testowanego kwiatka do wszystkich innych kwiatków:
	 * Key: [4.7, 3.2, 1.3, 0.2]
	 * Value:
	 * Key: 0.0, Value: Iris-setosa
	 * Key: 0.24494897427831802, Value: Iris-setosa
	 */
	public static HashMap<ArrayList<Double>, TreeMap<Double, String>> measureDistances(ArrayList<ArrayList<Double>> testSet, HashMap<String, ArrayList<ArrayList<Double>>> trainSet) {
		int i = 1;
		HashMap<ArrayList<Double>, TreeMap<Double, String>> outputDistances = new HashMap<>();

		for (ArrayList<Double> oneFlowerToTest : testSet) {
			TreeMap<Double, String> distance_flowerName = new TreeMap<>();
			for (String flowerName : trainSet.keySet()) {
				ArrayList<ArrayList<Double>> allDataForOneFlower = trainSet.get(flowerName);
				for (ArrayList<Double> oneFlowerData : allDataForOneFlower) {

					double distance = calculateDistance(oneFlowerToTest, oneFlowerData);

					distance_flowerName.put(distance, flowerName);
				}
			}
			outputDistances.put(oneFlowerToTest, distance_flowerName);
			i++;
		}

//		for (Map.Entry<ArrayList<Double>, TreeMap<Double, String>> entry : outputDistances.entrySet()) {
//			System.out.println("Key: " + entry.getKey());
//			for (Map.Entry<Double, String> innerEntry : entry.getValue().entrySet()) {
//				System.out.println("  Distance: " + innerEntry.getKey() + ", Class: " + innerEntry.getValue());
//			}
//		}


		return outputDistances;
	}


	/**
	 * @countKNearestNeighbors Funkcja przyjmuje dane z metody measureDistanes
	 * Funkcja zlicza k najbliższych sąsiadów i zwraca dane w postaci:
	 * Key: [4.7, 3.2, 1.3, 0.2]
	 * Value:
	 * Key: Iris-Setosa, Value: 28
	 * Key: Iris-versicolor, Value: 2
	 * itd.
	 */
	public static HashMap<ArrayList<Double>, TreeMap<String, Integer>> countKNearestNeighbors(HashMap<ArrayList<Double>, TreeMap<Double, String>> outputDistances, int k) {
		HashMap<ArrayList<Double>, TreeMap<String, Integer>> countNeighbors = new HashMap<>();
		int count = 0;

		for (ArrayList<Double> flowerIndex : outputDistances.keySet()) {
			TreeMap<Double, String> distances_names = outputDistances.get(flowerIndex);
			TreeMap<String, Integer> nearestNeighborCounts = new TreeMap<>();

			for (Map.Entry<Double, String> neighborEntry : distances_names.entrySet()) {
				if (count >= k) {
					break;
				}
				String neighborName = neighborEntry.getValue();


				nearestNeighborCounts.put(neighborName, nearestNeighborCounts.getOrDefault(neighborName, 0) + 1);

				count++;
			}

			countNeighbors.put(flowerIndex, nearestNeighborCounts);


			count = 0;
		}

//		for (Map.Entry<ArrayList<Double>, TreeMap<String, Integer>> entry : countNeighbors.entrySet()) {
//			ArrayList<Double> key = entry.getKey();
//			TreeMap<String, Integer> value = entry.getValue();
//			System.out.println("Klucz: " + key);
//			System.out.println("Wartość:");
//			for (Map.Entry<String, Integer> innerEntry : value.entrySet()) {
//				String innerKey = innerEntry.getKey();
//				Integer innerValue = innerEntry.getValue();
//				System.out.println("  " + innerKey + ": " + innerValue);
//			}
//		}

		return countNeighbors;
	}


	/**
	 * @printNearestNeighborAndAccuracy Funkcja przyjmuje testSet - listę list oraz dane które zwraca funkcja countKNearestNeighbors
	 * Funkcja wybiera największy zbiór z countNeighbors i printuje jego klucz - nazwę kwiatka oraz liczy dokładność
	 */
	public static void printNearestNeighborAndAccuracy(ArrayList<ArrayList<Double>> testSet, HashMap<ArrayList<Double>, TreeMap<String, Integer>> countNeighbors) {
		int accurateGuesses = 0;
		int maxGuesses = testSet.size();

		for (ArrayList<Double> flowerIndex : countNeighbors.keySet()) {
			TreeMap<String, Integer> neighborCounts = countNeighbors.get(flowerIndex);


			int maxCount = 0;
			String maxNeighbor = null;
			for (Map.Entry<String, Integer> entry : neighborCounts.entrySet()) {
				if (entry.getValue() > maxCount) {
					maxCount = entry.getValue();
					maxNeighbor = entry.getKey();
				}
			}


			if (maxNeighbor != null) {
				System.out.println("Najczęściej występujący sąsiad dla kwiatka " + flowerIndex + ": " + maxNeighbor);
			} else {
				System.out.println("Brak danych dla kwiatka " + flowerIndex);
			}

			String filePath = "D:\\Users\\Emil\\FlowersKNNClasification\\src\\trainSet.txt";
			try {
				BufferedReader br = new BufferedReader(new FileReader(filePath));

				String line;
				while ((line = br.readLine()) != null) {

					if (compareLineToArrayList(line, flowerIndex)) {
						if (line.contains(maxNeighbor)) {
							accurateGuesses += 1;
						}
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		System.out.println("Dokładność: " + accurateGuesses + " / " + maxGuesses);
	}

	public static double calculateDistance(ArrayList<Double> data1, ArrayList<Double> data2) {
		if (data1.size() != data2.size()) {
			throw new IllegalArgumentException("Wektory nie są tych samych wymiarów!");
		}

		double distance = 0.0;
		for (int i = 0; i < data1.size(); i++) {
			distance += Math.pow(data1.get(i) - data2.get(i), 2);
		}
		return Math.sqrt(distance);
	}

	public static boolean compareLineToArrayList(String trainSetFileLine, ArrayList<Double> targetArrayList) throws IOException {


		ArrayList<Double> lineToCompare = new ArrayList<>();
		String[] values = trainSetFileLine.split(";");

		for (int i = 0; i < values.length - 1; i++) {
			lineToCompare.add(Double.valueOf(values[i]));
		}
		if (lineToCompare.equals(targetArrayList)) {
			return true;
		}

		return false;
	}
}


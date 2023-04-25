import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriver driver;
	public ChromeOptions chromeOptions = new ChromeOptions();
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilButton(WebElement element) {
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickCross() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='Modal-module_closeIcon__b4z74']")).click();
	}

	public void wordleUp() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
			List<WebElement> boxes = driver.findElements(By.xpath("//div[@class='Tile-module_tile__3ayIZ']"));
			System.out.println(boxes.size());
			int currentRow = 0;
			BufferedReader br = new BufferedReader(
					new FileReader(new File("/home/prateekyadav/eclipse-workspace/WORDLE/src/main/resources/words")));
			ArrayList<String> word = new ArrayList<String>();
			while (br.readLine() != null) {
				word.add(br.readLine());
			}
			br.close();
			int j = 0;
			int rowCounter = 1;
			while (true) {
				String[] arr = word.get(j).split("");
				for (int i = currentRow; i < 5 + currentRow; i++) {
					driver.findElement(By.xpath("//button[text()='" + arr[i] + "']")).click();
				}
				driver.findElement(By.xpath("//button[text()='enter']")).click();
				Thread.sleep(2000);
				if (!(driver
						.findElements(
								By.xpath("//div[@aria-label='Row " + rowCounter + "']//div[@data-state='present']"))
						.size() > 0
						|| driver
								.findElements(By.xpath(
										"//div[@aria-label='Row " + rowCounter + "']//div[@data-state='correct']"))
								.size() > 0)) {
					js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

					for (int i = currentRow; i < 5 + currentRow; i++) {
						driver.findElement(By.xpath("//button[@aria-label='backspace']")).click();
					}
					j++;
				} else {
					String[] present;
					String[] correct;

					ArrayList<WebElement> presentList = (ArrayList<WebElement>) driver.findElements(
							By.xpath("//div[@aria-label='Row " + rowCounter + "']//div[@data-state='present']"));
					present = new String[presentList.size()];

					ArrayList<WebElement> correctList = (ArrayList<WebElement>) driver.findElements(
							By.xpath("//div[@aria-label='Row " + rowCounter + "']//div[@data-state='correct']"));
					correct = new String[correctList.size()];

					if (presentList.size() > 0) {
						present = populateArray(presentList);
					}
					if (correctList.size() > 0) {
						correct = populateArray(correctList);
					}

					int[] correctIndexes = new int[correct.length];
					for (int i = 0; i < correct.length; i++) {
						correctIndexes[i] = word.get(j).indexOf(correct[i]);
					}

					int[] inCorrectIndexes = new int[present.length];
					for (int i = 0; i < present.length; i++) {
						inCorrectIndexes[i] = word.get(j).indexOf(present[i]);
					}

					System.out.println(Arrays.toString(present));
					System.out.println(Arrays.toString(correct));
					System.out.println(Arrays.toString(correctIndexes));
					word = arrayTrimming(word, correct, present, correctIndexes, inCorrectIndexes);
					rowCounter++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String[] populateArray(ArrayList<WebElement> arr) {
		String[] ans = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			ans[i] = arr.get(i).getText().toLowerCase();
		}
		return ans;
	}

	public ArrayList<String> arrayTrimming(ArrayList<String> wordList, String[] correct, String[] present,
			int[] corrIndex, int[] inCorrIndex) throws InterruptedException {
		ArrayList<String> ans = new ArrayList<String>();
		ArrayList<String> realAns = new ArrayList<String>();
		List<String> p = Arrays.asList(present);
		List<String> c = Arrays.asList(correct);

		for (String word : wordList) {
			System.out.println(word);
			List<String> l1 = new ArrayList<String>();
			if (word != null) {
				l1 = Arrays.asList(word.toLowerCase().split(""));
			}
			if (present.length > 0 && correct.length > 0) {
				if (l1.containsAll(p) && l1.containsAll(c)) {
					System.out.println("IF 1");
					for (int i = 0; i < inCorrIndex.length; i++) {
						if (!(word.indexOf(present[i]) == inCorrIndex[i])) {
							ans.add(word);
						}
					}
				}
			} else if (present.length > 0) {
				System.out.println("IF 2");
				if (l1.containsAll(p)) {
					int totalCorr = 0;
					for (int i = 0; i < corrIndex.length; i++) {
						if ((word.indexOf(correct[i]) == corrIndex[i])) {
							totalCorr += 1;
						}
					}
					for (int i = 0; i < inCorrIndex.length; i++) {
						if (!(word.indexOf(present[i]) == inCorrIndex[i])) {
							ans.add(word);
						}
					}
					if (totalCorr == corrIndex.length) {
						ans.add(word);
					}
				}
			} else if (correct.length > 0) {
				System.out.println("IF 2");
				if (l1.containsAll(c)) {
					int totalCorr = 0;
					for (int i = 0; i < corrIndex.length; i++) {
						if ((word.indexOf(correct[i]) == corrIndex[i])) {
							totalCorr += 1;
						}
					}
					if (totalCorr == corrIndex.length) {
						ans.add(word);
					}
				}
			} else {
				ans.add(word);
			}
		}

//		for (String word : ans) {
//			List<String> l1 = Arrays.asList(word.toLowerCase().split(""));
//			if (l1.containsAll(p)) {
//				System.out.println("real if 1");
//				for (int i = 0; i < inCorrIndex.length; i++) {
//					if (!(word.indexOf(present[i]) == inCorrIndex[i])) {
//						realAns.add(word);
//					}
//				}
//			} else {
//				System.out.println("real else");
//				realAns.add(word);
//			}
//		}

		ArrayList<String> wrongKeys = findWrongLetters();
		String correctWordSubstring = String.join(",", correct);
		System.out.println("correctWordSubstring: " + correctWordSubstring);
		for (int i = 0; i < ans.size(); i++) {
			if (wordList.get(i) != null) {
				List<String> currWord = Arrays.asList(ans.get(i).split(""));
				if (currWord.containsAll(wrongKeys)) {
//					System.out.println("Correct word: " + wordList.get(i));
					ans.remove(i);
				}
			}

		}
		return ans;

	}

	public ArrayList<String> findWrongLetters() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> wrongLetters = driver.findElements(By.xpath("//button[@data-state='absent']"));
		ArrayList<String> ans = new ArrayList<String>();
		for (WebElement ele : wrongLetters) {
			System.out.println("Wrong keys: >>>>>>>>>>>>>>>>>>>> " + ele.getText());
			ans.add(ele.getText().toLowerCase());
		}

		return ans;
	}

	public void fillWordList() throws IOException {
		List<WebElement> wordsElementList = driver.findElements(By.xpath("//li[text()]"));
		FileWriter fileWrite = new FileWriter("/home/prateekyadav/eclipse-workspace/WORDLE/src/main/resources/words");
		for (WebElement ele : wordsElementList) {
			fileWrite.write(ele.getText() + "\n");
		}
		fileWrite.close();
	}

}

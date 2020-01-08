/**
 * Program the return the minimum questions to solve to achieve the given threshold value. the questions are given in the form
 * of array where each number represents the marks for that particular question.
 * Threhold is calculated as max mark que - min mark question
 * eg. Array - [1,2,3,4]. threshold - 3. o/p = [1,2,4] or [1,3,4] i.e e questions need to be solved to achieve threshold(4-1=3)
 * NOTE - a person must solve first question and then can skip at the most 1 question to proceed. Also the array given is sorted.
 * return -1 if threshold can't be reached from all given questions
 * @author Deep Chitroda
 */
import java.util.ArrayList;
import java.util.List;

public class mathHomework {
	public int questionsToSolve(int threshold, List<Integer> questions)
	{
		int minQueCount = 1;
		for (int i = 1; i < questions.size(); i++) //skipping the first question as it is mandatory
		{
			if(questions.get(i)-questions.get(0) == threshold)
			{
				minQueCount++; // increment if a que can be attempted 
				//System.out.println("the questions attempted without skipping question : "+questions.get(i));
				return minQueCount;
			}
			else
			{
				if((i+1) < questions.size()) // check if index doesn't go out of bound
				{	
					if(questions.get(i+1)-questions.get(0) == threshold) // check if we can skip a question
					{
						minQueCount++; // increment if a que can be attempted
						//System.out.println("the questions attempted by skipping question : "+questions.get(i));
						return minQueCount;
					}
					else
					{
						minQueCount++; // increase the counter to move to next question
						//System.out.println("the question attempted is : "+questions.get(i)+",");
						i++;
					}
				}
				else
				{
					//System.out.println("there are no ways to achieve threshold");
					return -1;
				}
			}
		}
		return minQueCount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(5);
		list.add(9);
		list.add(10);
		list.add(18);
		list.add(22);
		list.add(25);
		mathHomework m = new mathHomework();
		System.out.println("the min no. of questions to solve : "+m.questionsToSolve(1,list));
	}
}

import java.text.DecimalFormat;
import java.util.Scanner;

public class LagbajaSchools {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many students do you have? ");
        int numStudents = scanner.nextInt();
        System.out.print("How many subjects do they offer? ");
        int numSubjects = scanner.nextInt();
        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>> saved successfully");

        int[][] scores = new int[numStudents][numSubjects];
        for (int count = 0; count < numStudents; count++) {
            System.out.println("Entering score for student " + (count + 1));
            for (int index = 0; index < numSubjects; index++) {
                while (true) {
                    System.out.print("Enter score for subject " + (index + 1) + ": ");
                    int score = scanner.nextInt();
                    if (score >= 0 && score <= 100) {
                        scores[count][index] = score;
                        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>> saved successfully");
                        break;
                    } else {
                        System.out.println("Invalid score. Please enter a score between 0 and 100.");
                    }
                }
            }
        }

        System.out.println("\nClass Summary:");
        System.out.println("Students\tSub1\tSub2\tSub3\tTot\tAve\tPos");
        int[] totals = new int[numStudents];
        double[] averages = new double[numStudents];
        for (int count = 0; count < numStudents; count++) {
            int total = 0;
            for (int index = 0; index < numSubjects; index++) {
                total += scores[count][index];
            }
            totals[count] = total;
            averages[count] = (double) total / numSubjects;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("Student " + (count + 1) + "\t" + scores[count][0] + "\t" + scores[count][1] + "\t" + scores[count][2] + "\t" + total + "\t" + df.format(averages[count]) + "\t" + (count + 1));
        }

        System.out.println("\nSubject Summary:");
        int hardestSubject = 0;
        int easiestSubject = 0;
        int hardestSubjectFails = 0;
        int easiestSubjectPasses = 0;
        int overallHighestScore = 0;
        int overallHighestScoreStudent = 0;
        int overallHighestScoreSubject = 0;
        for (int index = 0; index < numSubjects; index++) {
            int maxScore = scores[0][index];
            int maxStudent = 0;
            int minScore = scores[0][index];
            int minStudent = 0;
            int totalScore = 0;
            int numPasses = 0;
            int numFails = 0;
            for (int count = 0; count < numStudents; count++) {
                if (scores[count][index] > maxScore) {
                    maxScore = scores[count][index];
                    maxStudent = count;
                }
                if (scores[count][index] < minScore) {
                    minScore = scores[count][index];
                    minStudent = count;
                }
                totalScore += scores[count][index];
                if (scores[count][index] >= 50) {
                    numPasses++;
                } else {
                    numFails++;
                }
            }
            double averageScore = (double) totalScore / numStudents;
            System.out.println("Subject " + (index + 1) + " highest scoring student is: Student " + (maxStudent + 1));
            System.out.println("Subject " + (index + 1) + " lowest scoring student is: Student " + (minStudent + 1));
            System.out.println("Subject " + (index + 1) + " total score is: " + totalScore);
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("Subject " + (index + 1) + " average score is: " + df.format(averageScore));
            System.out.println("Subject " + (index + 1) + " number of passes: " + numPasses);
            System.out.println("Subject " + (index + 1) + " number of fails: " + numFails);

            if (numFails > hardestSubjectFails) {
                hardestSubject = index;
                hardestSubjectFails = numFails;
            }
            if (numPasses > easiestSubjectPasses) {
                easiestSubject = index;
                easiestSubjectPasses = numPasses;
            }
            if (maxScore > overallHighestScore) {
                overallHighestScore = maxScore;
		overallHighestScoreStudent = maxStudent;
                overallHighestScoreSubject = index;
            }
        }

        System.out.println("The hardest subject is subject " + (hardestSubject + 1) + " with " + hardestSubjectFails + " failures");
        System.out.println("The easiest subject is subject " + (easiestSubject + 1) + " with " + easiestSubjectPasses + " passes");
        System.out.println("The overall highest score is scored by student " + (overallHighestScoreStudent + 1) + " in subject " + (overallHighestScoreSubject + 1) + " scoring: " + overallHighestScore);

        System.out.println("============================================================== CLASS SUMMARY =======================================");
        int bestGraduatingStudent = 0;
        int bestGraduatingStudentScore = 0;
        int worstGraduatingStudent = 0;
        int worstGraduatingStudentScore = 0;
        int classTotalScore = 0;
        for (int count = 0; count < numStudents; count++) {
            classTotalScore += totals[count];
            if (totals[count] > bestGraduatingStudentScore) {
                bestGraduatingStudent = count;
                bestGraduatingStudentScore = totals[count];
            }
            if (totals[count] < worstGraduatingStudentScore || worstGraduatingStudentScore == 0) {
                worstGraduatingStudent = count;
                worstGraduatingStudentScore = totals[count];
            }
        }
        double classAverageScore = (double) classTotalScore / numStudents;
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Best graduating student is: student " + (bestGraduatingStudent + 1) + " scoring: " + bestGraduatingStudentScore);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Worst graduating student is: student " + (worstGraduatingStudent + 1) + " scoring: " + worstGraduatingStudentScore);
        System.out.println("===============================================================");
        System.out.println("Class total score is: " + classTotalScore);
        System.out.println("Class average score is: " + df.format(classAverageScore));
        System.out.println("===============================================================");
    }
}





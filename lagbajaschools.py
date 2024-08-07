import decimal

def main():
    num_students = int(input("How many students do you have? "))
    num_subjects = int(input("How many subjects do they offer? "))

    scores = []
    for count in range(num_students):
        student_scores = []
        print("Entering score for student", count + 1)
        for index in range(num_subjects):
            while True:
                score = int(input("Enter score for subject " + str(index + 1) + ": "))
                if 0 <= score <= 100:
                    student_scores.append(score)
                    break
                else:
                    print("Invalid score. Please enter a score between 0 and 100.")
        scores.append(student_scores)

    print("\nClass Summary:")
    print("Students\tSub1\tSub2\tSub3\tTot\tAve\tPos")
    totals = []
    averages = []
    for count, student_scores in enumerate(scores):
        total = sum(student_scores)
        average = decimal.Decimal(total) / decimal.Decimal(num_subjects)
        totals.append(total)
        averages.append(average)
        print("Student", count + 1, "\t", student_scores[0], "\t", student_scores[1], "\t", student_scores[2], "\t", total, "\t", round(average, 2), "\t", count + 1)

    hardest_subject = 0
    easiest_subject = 0
    hardest_subject_fails = 0
    easiest_subject_passes = 0
    for index in range(num_subjects):
        num_passes = 0
        num_fails = 0
        for count in range(num_students):
            if scores[count][index] >= 50:
                num_passes += 1
            else:
                num_fails += 1
        if num_fails > hardest_subject_fails:
            hardest_subject = index
            hardest_subject_fails = num_fails
        if num_passes > easiest_subject_passes:
            easiest_subject = index
            easiest_subject_passes = num_passes

    overall_highest_score = 0
    overall_highest_score_student = 0
    overall_highest_score_subject = 0
    for count in range(num_students):
        for index in range(num_subjects):
            if scores[count][index] > overall_highest_score:
                overall_highest_score = scores[count][index]
                overall_highest_score_student = count
                overall_highest_score_subject = index

    best_graduating_student = 0
    best_graduating_student_score = 0
    worst_graduating_student = 0
    worst_graduating_student_score = 0
    for count in range(num_students):
        if totals[count] > best_graduating_student_score:
            best_graduating_student = count
            best_graduating_student_score = totals[count]
        if totals[count] < worst_graduating_student_score or worst_graduating_student_score == 0:
            worst_graduating_student = count
            worst_graduating_student_score = totals[count]

    print("\nThe hardest subject is subject", hardest_subject + 1, "with", hardest_subject_fails, "fails")
    print("The easiest subject is subject", easiest_subject + 1, "with", easiest_subject_passes, "passes")
    print("The overall highest score is scored by student", overall_highest_score_student + 1, "in subject", overall_highest_score_subject + 1, "scoring:", overall_highest_score)
    print("\nBest graduating student is: student", best_graduating_student + 1, "scoring:", best_graduating_student_score)
    print("Worst graduating student is: student", worst_graduating_student + 1, "scoring:", worst_graduating_student_score)


print("The hardest subject is subject", hardest_subject + 1, "with", hardest_subject_fails, "failures")
print("The easiest subject is subject", easiest_subject + 1, "with", easiest_subject_passes, "passes")
print("The overall highest score is scored by student", overall_highest_score_student + 1, "in subject", overall_highest_score_subject + 1, "scoring:", overall_highest_score)
print("The overall highest score is scored by student", overall_highest_score_student + 1, "in subject", overall_highest_score_subject + 1, "scoring:", overall_highest_score)

print("\n============================================================== CLASS SUMMARY =======================================")
print("Best graduating student is: student", best_graduating_student + 1, "scoring:", best_graduating_student_score)
print("=============================================== !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
print("Worst graduating student is: student", worst_graduating_student + 1, "scoring:", worst_graduating_student_score)
print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
print("=============================================")
class_total_score = sum(totals)
class_average_score = decimal.Decimal(class_total_score) / decimal.Decimal(num_students)
print("Class total score is:", class_total_score)
print("Class average score is:", round(class_average_score, 2))
print("=============================================")

if __name__ == "__main__":
    main()



package de.jplag;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Optional;

/**
 * Collection of submissions and their basecode if it exists.
 */
public class SubmissionSet {
    /**
     * Submissions to check for plagiarism.
     */
    private List<Submission> submissions;

    /**
     * Base code submission if it exists.
     */
    private final Optional<Submission> baseCodeSubmission;

    /**
     * @param submissions Submissions to check for plagiarism.
     * @param baseCodeSubmission Base code submission if it exists.
     */
    public SubmissionSet(List<Submission> submissions, Optional<Submission> baseCodeSubmission) {
        setSubmissions(submissions);
        this.baseCodeSubmission = baseCodeSubmission;
    }

    /**
     * @return Whether a basecode is available for this collection.
     */
    public boolean hasBaseCode() {
        return !baseCodeSubmission.isEmpty();
    }

    /**
     * Retrieve the base code of this collection.
     * @return The base code submission.
     * @note Asking for a non-existing basecode crashes the program.
     * @see #hasBaseCode
     */
    public Submission getBaseCode() {
        if (baseCodeSubmission.isEmpty()) {
            throw new AssertionError("Querying a non-existing basecode submission.");
        }
        return baseCodeSubmission.get();
    }

    /**
     * @return The number of submissions.
     */
    public int numberOfSubmissions() {
        return submissions.size();
    }

    /**
     * Obtain the submissions.
     * @note Changes in the list are reflected in this instance.
     */
    public List<Submission> getSubmissions() {
        return submissions;
    }

    /**
     * Give the submissions to the set.
     * @param submissions New submissions to store.
     */
    public void setSubmissions(List<Submission> submissions) {
        if (submissions == null) {
            this.submissions = emptyList();
        } else {
            this.submissions = submissions;
        }
    }
}
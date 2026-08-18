# Issue to assign to the coding agent

Copy the title and body below into a new GitHub issue, then assign it to Copilot
(or open Copilot agent mode and paste the body as the task).

---

**Title:** Implement TodoService.upcomingTodos

**Body:**

Implement the `upcomingTodos` function in
`src/main/kotlin/com/noaduron/todo/TodoService.kt`. It currently throws.

A todo is upcoming when all of the following hold:
- its status is not `ARCHIVED`;
- it has a due date (dueDate is not null);
- its due date is on or after `now` (a todo due exactly on `now` is included).

Return the upcoming todos sorted by due date ascending (earliest first). Exclude
everything else.

Acceptance criteria:
- All tests in `src/test/kotlin/com/noaduron/todo/TodoServiceTest.kt` pass.
- CI is green.
- The code, the commit messages and the pull request follow the delivery standards
  described in `README.md` (code style, commit format, and the PR sections
  Context / What changed / Why / Potential bugs / Future improvements).

Do not modify the tests.

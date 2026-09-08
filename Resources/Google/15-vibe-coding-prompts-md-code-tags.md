# 15 Vibe Coding Prompts

> Copy, fill the brackets, and ship. One prompt for every stage.

## Table of Contents

1. [Write a Full PRD](#01--write-a-full-prd)
2. [Create Your CLAUDE.md](#02--create-your-claudemd)
3. [Ultra Plan Mode](#03--ultra-plan-mode)
4. [Spec-Driven Development](#04--spec-driven-development)
5. [Full UI & UX Design Brief](#05--full-ui--ux-design-brief)
6. [Implementation Plan](#06--implementation-plan)
7. [Wire Up an MCP Server](#07--wire-up-an-mcp-server)
8. [Connect Your Database](#08--connect-your-database)
9. [Find Security Gaps](#09--find-security-gaps)
10. [Debug an Error Fast](#10--debug-an-error-fast)
11. [E2E Test Your Application](#11--e2e-test-your-application)
12. [Clean Up Dead Code](#12--clean-up-dead-code)
13. [Write Clean Git Commits](#13--write-clean-git-commits)
14. [Hooks as Guardrails](#14--hooks-as-guardrails)
15. [Turn a Task Into a Skill](#15--turn-a-task-into-a-skill)

## The 15 Prompts at a Glance

| # | Prompt | Use it when |
|---|---|---|
| 01 | Write a Full PRD | Before building anything new |
| 02 | Create Your `CLAUDE.md` | Once per project, first session |
| 03 | Ultra Plan Mode | Any task touching multiple files |
| 04 | Spec-Driven Development | Features that must not drift |
| 05 | Full UI & UX Design Brief | Before designing a screen or flow |
| 06 | Implementation Plan | After the spec is approved |
| 07 | Wire Up an MCP Server | Connecting Claude to outside tools |
| 08 | Connect Your Database | Setting up Postgres / Supabase |
| 09 | Find Security Gaps | Before anything goes live |
| 10 | Debug an Error Fast | The moment an error appears |
| 11 | E2E Test Your Application | Locking in your money flows |
| 12 | Clean Up Dead Code | When the repo starts feeling heavy |
| 13 | Write Clean Git Commits | Every single commit |
| 14 | Hooks as Guardrails | Automating your quality checks |
| 15 | Turn a Task Into a Skill | Anything you have done 3+ times |

## The Prompts

### 01 -- Write a Full PRD

```md
Write a complete PRD for the feature below.

Feature: [DESCRIBE FEATURE]
Users: [WHO USES IT]
Stack: [YOUR STACK]

Include:

* Problem statement + success metrics
* User stories with acceptance criteria
* Scope: what ships in v1, what does not
* Data model changes
* Edge cases + failure states
* Open questions for me to answer

Keep it under 2 pages. Be specific, no filler.
Save it as docs/prd-[feature].md so every later
prompt can reference it.
```

### 02 -- Create Your

```md
Scan this entire codebase, then generate a CLAUDE.md.

Include:

* What this project is, in 2 lines
* Tech stack + the versions that matter
* Commands: [DEV / BUILD / TEST / LINT]
* Architecture: where things live and why
* Code conventions you actually detect in the code
* Hard rules: [YOUR NON-NEGOTIABLES] -- what to
  never touch without asking
* Gotchas a new engineer would hit in week 1

Write rules as short imperatives. Nothing generic --
only what is true for THIS repo. If you are unsure
about a rule, ask me instead of inventing it.
```

### 03 -- Ultra Plan Mode

```md
Enter plan mode. Do NOT write any code yet.

Task: [PASTE TASK]
Constraints: [DEADLINE / STACK / NO-GO ZONES]

1. Read every file this task touches, list them
   with one line on what each does today
2. Map current behavior vs target behavior
3. Propose 2-3 approaches with real tradeoffs:
   complexity, risk, blast radius
4. Pick one and justify it in 3 lines
5. Break it into steps small enough to verify
   one at a time, each with its own check
6. List risks + the exact rollback for each
7. Flag anything touching [AUTH / PAYMENTS /
   PROD DATA] for my explicit sign-off

Then stop. Show me the plan and wait for my
approval before touching a single file.
```

### 04 -- Spec-Driven Development

```md
We build specs first. Write a spec for: [FEATURE]

Context: [WHO USES IT + WHY NOW]

Spec format:

* Behavior: given / when / then, every case --
  happy path, edge cases, failure states
* API contract: inputs, outputs, error shapes,
  status codes
* Data: schema changes + migrations needed
* UI states: loading, empty, error, success
* Non-goals: what this spec deliberately skips
* Acceptance checklist I can verify line by line

After I approve the spec, implement EXACTLY the
spec. If reality forces a deviation, stop, update
the spec, get my ok, then continue. The spec is
the source of truth, not the code.
```

### 05 -- Full UI & UX Design Brief

```md
Create a full UI/UX design brief for: [SCREEN OR FLOW]

Audience: [USERS]
Brand: [COLORS / FONTS / VIBE]

Deliver:

* User journey through the flow, step by step
* Layout per screen: hierarchy, spacing, breakpoints
* Component inventory with every state --
  hover, empty, error, loading
* Typography + color tokens
* Motion: what animates, duration, easing
* Accessibility notes

Study patterns from [2-3 PRODUCTS YOU ADMIRE]
for direction. Never copy them.
```

### 06 -- Implementation Plan

```md
Create an implementation plan for: [APPROVED
SPEC / PRD]

Rules:

* Sequence steps so the app compiles and runs
  after EVERY single step
* Each step: files touched, what changes,
  how I verify it works
* Flag steps needing a migration or new dependency
* Put the riskiest unknowns first
* Size each step: [S / M / L]

Output a numbered build sequence I can run one
step at a time. Wait for my "go" between steps.
```

### 07 -- Wire Up an MCP Server

```md
Wire up an MCP server for: [SERVICE / API]

What I need it to do: [JOBS TO BE DONE]

1. Check for an official or well-maintained
   existing server first -- name your source
2. If one exists: exact install command + the
   .mcp.json config, scoped to this project
3. If not: scaffold one with the MCP SDK --
   tools, auth, error handling, typed responses
4. Add ONLY the tools I will actually use: [LIST]
5. Wire secrets through [ENV VARS], never
   hardcode keys in the config file
6. Verify the connection and call one tool
   end to end, show me the output
7. Document each tool in 1 line so future
   sessions know when to reach for it
```

### 08 -- Connect Your Database

```md
Connect this app to [POSTGRES / SUPABASE / YOUR DB].

* Pick the client that fits this stack,
  justify it in 1 line
* Env vars: name them, add to .env.example,
  never commit real values
* Schema: tables for [ENTITIES] with types,
  relations, and indexes for [HOT QUERIES]
* Create + run the migrations, and show me
  the rollback for each one
* One typed query helper per table -- no raw
  SQL scattered through components
* Access rules / row-level security if this
  is [MULTI-TENANT]
* Connection pooling if we are serverless

Then prove it: seed one row, read it back,
show me the output.
```

### 09 -- Find Security Gaps

```md
Audit this codebase for security gaps.
Attack it like you want in.

Focus areas: [AUTH / PAYMENTS / USER DATA]

Check:

* Secrets in code, config, or git history
* Injection: SQL, XSS, command, path traversal
* Auth: routes missing checks, weak sessions,
  broken redirects
* IDOR: can user A read user B's data?
* File uploads + input validation on every form
* Dependency CVEs -- run the audit, read it
* Rate limiting on [EXPENSIVE ENDPOINTS]
* What leaks through error messages and logs

Rank findings by severity with exact file:line,
fix the critical ones now, and list the rest
as tickets with effort estimates.
```

### 10 -- Debug an Error Fast

```md
Debug this error. Do NOT guess.

Error: [PASTE FULL ERROR + STACK TRACE]
When it happens: [STEPS TO REPRODUCE]

1. Read the stack trace, open the exact files
   involved
2. State expected vs actual behavior in 1 line
3. List 3 hypotheses, ranked by likelihood
4. Prove or kill each one with logs or a tiny
   test -- evidence, not vibes
5. Fix the root cause, not the symptom
6. Search the repo for the same pattern -- if
   it can break here, it breaks elsewhere
7. Add a regression test that fails without
   the fix
8. Tell me in 2 lines why it broke and why it
   can never break this way again
```

### 11 -- E2E Test Your Application

```md
Write Playwright E2E tests for: [FLOW]

Stack: [YOUR STACK] CI: [GITHUB ACTIONS / OTHER]

* Money paths first: [SIGNUP / CHECKOUT /
  CORE ACTION]
* Test what the user sees, not implementation
  details
* Selectors: roles and labels, never brittle
  CSS chains
* One unhappy path per flow: bad input,
  network failure, expired session
* Tests stay independent -- any order, zero
  shared state, each seeds its own data
* Headless in CI, headed locally for debugging
* Screenshots + traces on failure only

Run the suite, show me the results, fix what
fails, and tell me what the suite still does
NOT cover.
```

### 12 -- Clean Up Dead Code

```md
Find and delete dead code in this repo.

Scope: [WHOLE REPO / SPECIFIC FOLDER]

* Unused exports, components, hooks, utils
* Unreachable branches + commented-out blocks
* package.json dependencies nothing imports
* Stale feature flags stuck always-on or
  always-off
* Duplicate logic that should merge into one
* Dead CSS classes and unused assets

Verify with a search before EVERY deletion --
dynamic imports and string references count.
Delete in small commits, run [BUILD + TESTS]
after each one, and report total lines removed
plus anything you were not 100% sure about.
```

### 13 -- Write Clean Git Commits

```md
Commit my staged changes properly.

Convention: [CONVENTIONAL COMMITS / YOUR FORMAT]

* Split unrelated changes into separate commits
* Format: type(scope): what changed and why
  feat / fix / refactor / chore / docs / test
* Subject under 50 chars, imperative mood
* Body explains the WHY, wrapped at 72
* Reference the ticket: [TICKET-ID]
* Never mix a refactor with a behavior change
  in one commit
* Never commit [SECRETS / .ENV / GENERATED
  FILES]

Show me the plan -- files per commit + messages --
before you commit anything. Then commit one at
a time so I can stop you between them.
```

### 14 -- Hooks as Guardrails

```md
Set up Claude Code hooks as guardrails here.

Stack: [YOUR STACK + PACKAGE MANAGER]

* PostToolUse: run [LINT + TYPECHECK] after
  every file edit, feed errors straight back
* PreToolUse: block edits to [PROTECTED PATHS:
  MIGRATIONS, .ENV, PROD CONFIG]
* Stop: run [TEST SUITE] before a session ends
* Notification: ping me with [SOUND / SLACK]
  when my input is needed

Write the hook scripts + the settings.json
entries. Keep each script under 20 lines and
exit non-zero with a clear message so the
agent knows exactly what to fix. Then trigger
each hook on purpose and show me it firing.
```

### 15 -- Turn a Task Into a Skill

```md
Turn this repetitive task into a Claude Code skill.

The task I keep doing: [DESCRIBE TASK + STEPS]

* Create .claude/skills/[NAME]/SKILL.md
* Frontmatter: name + description with the exact
  trigger phrases I actually say
* Body: numbered workflow, my conventions,
  edge cases
* What it should ask me for vs infer on its own
* What "done" looks like

Then dry-run the skill on a real example and
refine until the output matches how I do it
by hand.
```

---

## Follow Manthan

- [Instagram](https://www.instagram.com/leadgenman/)
- [YouTube](https://www.youtube.com/@LeadGenMan)
- [TikTok](https://www.tiktok.com/@leadgenmanthan)
- [LinkedIn](https://www.linkedin.com/in/leadgenmanthan/)
- [Facebook](https://www.facebook.com/p/Lead-Gen-Man-61571060319687/)

## Products by Manthan

**TiltIt** — 3D animation software for content creators

- Website: [tiltit.video](http://tiltit.video/)
- Instagram: [@tiltit.video](https://www.instagram.com/tiltit.video/)

**PenAnywhere** — Mac screen annotator for presentations and tutorials

- Website: [penanywhere.com](http://penanywhere.com/)
- App Store: [Download](https://apps.apple.com/app/penanywhere/id6760774183)

You can also find Manthan on [LinkedIn](https://www.linkedin.com/in/leadgenmanthan/), [Instagram](https://www.instagram.com/leadgen_man/), [YouTube](https://www.youtube.com/@LeadGenMan), and [Udemy](https://courses.leadgenman.com/).

## Courses

- [Master n8n AI Agents](https://www.udemy.com/course/master-n8n-ai-agents-build-sell-ai-agents-and-no-code/?couponCode=6D4057A8F2834EE3FA84)
- [AI Voice Agent Course](https://www.udemy.com/course/master-ai-voice-agents-automate-calls-with-ai-and-no-code/?referralCode=56BDE4ACEE03F6017359)
- [Cold Email MasterCourse](https://www.udemy.com/course/cold-email-mastery-with-ai-ultimate-lead-generation-system/?referralCode=70B3F940F309878D2E77)
- [Rest of the Courses](https://courses.leadgenman.com/)

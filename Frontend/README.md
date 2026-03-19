# 🚀 React Learning Tracker

## Phase 1: Essentials
- [ ] Initialize projects with Vite
- [ ] JSX Syntax
- [ ] Functional Components
- [ ] Class Components
- [ ] Props vs State
- [ ] Lifting State Up
- [ ] Conditional Rendering
- [ ] Lists & Keys

## Phase 2: Hooks
- [ ] useState
- [ ] useEffect
- [ ] useRef
- [ ] useMemo
- [ ] useCallback
- [ ] useContext
- [ ] useReducer
- [ ] Custom Hooks

## Phase 3: Ecosystem
- [ ] React Router
- [ ] API Calls
- [ ] Styling
- [ ] Forms

## Phase 4: Scaling
- [ ] Redux Toolkit
- [ ] Recoil
- [ ] Next.js
- [ ] Testing

## Phase 5: Bonus
- [ ] React Native


DOCUMENTATION CONTENT for the each file/concept:

What is it?

Define the concept clearly in 2–4 lines.

Explain the core idea

Keep it simple + interview-ready

Example:
useState is a React Hook that allows functional components to manage internal state without using class components.

2️⃣ Why is it used?

Explain purpose + problem it solves

What issue existed before?

Why React introduced this?

Example:

Helps store dynamic data (like user input)

Enables UI updates without reloading

3️⃣ Where is it used?

Real-world usage (VERY IMPORTANT for interviews)

Give 1–2 practical examples

Example:

Login forms (store input values)

Toggle buttons (dark/light mode)

4️⃣ How is it used? (JSX Example)
import React, { useState } from "react";

const Counter = () => {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>{count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
};

👉 Explain briefly:

useState(0) → initial value

setCount → updates state

Re-render happens automatically

5️⃣ When should it be used?

Decision-making + interview insight

Use when:

Data changes over time

UI depends on dynamic values

Avoid when:

State is global → use Context/Redux

🎯 Interview Insight

This is your secret weapon section

Common question:
👉 "Difference between state and props?"

Key point:

State → mutable

Props → read-only
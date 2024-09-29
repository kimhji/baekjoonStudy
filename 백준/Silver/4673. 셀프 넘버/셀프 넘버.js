const arr = new Array(10001).fill(true);
arr[0] = false;
for (let idx = 1; idx <= 10000; idx++) {
  const number =
    idx +
    Math.floor(idx / 10000) +
    (Math.floor(idx / 1000) % 10) +
    (Math.floor(idx / 100) % 10) +
    (Math.floor(idx / 10) % 10) +
    (idx % 10);
  if (number > 10000) continue;
  arr[number] = false;
}
arr.forEach((flag, idx) => {
  if (flag) console.log(idx);
});

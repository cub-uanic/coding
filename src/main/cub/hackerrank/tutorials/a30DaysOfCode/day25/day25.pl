#!/usr/bin/env perl

# Enter your code here. Read input from STDIN. Print output to STDOUT

$n = <STDIN>;
chomp $n;
for (1 .. $n) {
  my $data = <STDIN>;
  chomp $data;
  my $isPrime = ($data != 1 && $data % 2 != 0) || $data == 2;
  my $j = 3;
  while ($isPrime && $j < sqrt($data) + 1) {
    $isPrime = $data % $j != 0;
    $j += 2;
  }
  print($isPrime ? "Prime\n" : "Not prime\n");
}

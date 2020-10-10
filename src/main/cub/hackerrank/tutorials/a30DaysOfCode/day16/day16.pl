#!/usr/bin/env perl

$S = <STDIN>;
chomp $S;

eval {
  my $N = 0 + $S;
  $N eq $S || die("error");
  print "$S\n";
} || print "Bad String\n";

use strict;
use warnings;
#use diagnostics;
use 5.20.1;

select(STDOUT);
$| = 1; # DO NOT REMOVE

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

sub newAlien {
    my ($type, $hp, $armor, $damage, $pewpew, $roundsToKill, $roundsToLive) = @_;

    $pewpew = $type eq "FIGHTER" ? 20 - $armor : 10 - $armor unless defined($pewpew);
    $pewpew = 1 unless $pewpew > 1;
    $roundsToLive = 1 unless defined($roundsToLive);

    return {
        type         => $type,
        hp           => $hp,
        armor        => $armor,
        damage       => $damage,
        pewpew       => $pewpew,
        roundsToKill => int($hp / $pewpew) + ($hp % $pewpew > 0 ? 1 : 0),
        roundsToLive => 1,
    };
}

my @aliens = ();
my $tokens;

chomp(my $n = <STDIN>);
for my $i (0 .. $n - 1) {
    chomp($tokens = <STDIN>);
    my ($type, $hp, $armor, $damage) = split(/ /, $tokens);
    push(@aliens, newAlien($type, $hp, $armor, $damage));
}

@aliens = sort {
    $a->{roundsToKill} * ($a->{damage} + $b->{damage}) + $b->{roundsToKill} * $b->{damage}
    <=>
    $b->{roundsToKill} * ($a->{damage} + $b->{damage}) + $a->{roundsToKill} * $a->{damage}
} @aliens;

my $totalRounds = 0;
my $hpRemainder = 5000;
for my $alien (@aliens) {
    $totalRounds += $alien->{roundsToKill};
    $alien->{roundsToLive} = $totalRounds;
    $hpRemainder -= $alien->{damage}*$alien->{roundsToLive};
}

# Write an answer using print
# To debug: print STDERR "Debug messages...\n";

print( $hpRemainder < 0 ? "FLEE":"$hpRemainder\n");
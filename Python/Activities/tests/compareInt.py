import pytest

@pytest.mark.great
def test_greater():
    x = 2
    y = 5
    assert y > x

@pytest.mark.skip
def test_greater_equal():
    x = 6
    y = 6
    assert y >= x

@pytest.mark.xfail
def test_lesser():
    x = 2
    y = 5
    assert x < y